"""
SANTÉ ENGINEERING INTERVIEW: CODING ARCHETYPE C
Problem: Invoice Log Grouping & Aggregation

CONTEXT:
Santé ingests flat-file delivery logs from regional alcohol distributors. These 
legacy systems output unstructured, comma-separated strings representing drop-offs.

YOUR TASK:
Write a function that parses a list of raw log strings and returns a nested 
dictionary showing the total quantity delivered per vendor, per item.

BUSINESS RULES & EDGE CASES:
1. Format: The expected format is "vendor_name,item_name,qty_{amount}".
   Example: "Southern Glazers,Titos 750ml,qty_12"
2. Dirty Data: Distributor systems inject random spaces. You must strip leading 
   and trailing whitespace from vendors and items.
3. The Prefix: The quantity field always contains a "qty_" prefix. You must 
   strip this prefix and convert the remainder to an integer.
4. Malformed Rows: If a row does not have exactly 3 columns, or if the quantity 
   is not a valid integer, ignore the row entirely (do not crash).
"""

from typing import List, Dict
from collections import defaultdict

def group_invoice_logs(logs: List[str]) -> Dict[str, Dict[str, int]]:
    res = defaultdict(lambda: defaultdict(int))
    for log in logs:
        log = log.strip()
        log_arr = log.split(",")
        if len(log_arr) != 3: continue
        v, m, q = log_arr[0].strip(), log_arr[1].strip(), log_arr[2].strip()
        if not q.startswith("qty_"): continue
        q = q.removeprefix("qty_")
        if not q.isdigit(): continue
        res[v][m] += int(q)
    return res


# =====================================================================
# TEST RUNNER
# =====================================================================
def run_tests():
    raw_logs = [
        # 1. Standard valid logs with aggregation
        "Southern Glazers,Titos 750ml,qty_12",
        "RNDC,Macallan 12,qty_6",
        "Southern Glazers,Titos 750ml,qty_24",
        "Southern Glazers,Casamigos Blanco,qty_12",
        
        # 2. Dirty strings (extra whitespace)
        "  RNDC , Macallan 12 , qty_6  ",
        
        # 3. Malformed rows (Should be safely ignored)
        "Empire Merchants,MissingQtyCol",
        "Empire Merchants,Highland Park,12",          # Missing 'qty_' prefix
        "Breakthru,Grey Goose,qty_abc",               # Invalid integer
        "",                                           # Empty string
    ]

    result = group_invoice_logs(raw_logs)

    # Assert Southern Glazers aggregation
    assert "Southern Glazers" in result, "Missing Southern Glazers"
    assert result["Southern Glazers"]["Titos 750ml"] == 36, "Failed to aggregate Titos"
    assert result["Southern Glazers"]["Casamigos Blanco"] == 12, "Failed to parse Casamigos"

    # Assert RNDC dirty string normalization
    assert "RNDC" in result, "Missing RNDC (or failed to strip whitespace)"
    assert result["RNDC"]["Macallan 12"] == 12, "Failed to aggregate dirty RNDC string"

    # Assert malformed rows were ignored
    assert "Empire Merchants" not in result, "Included malformed row (Empire)"
    assert "Breakthru" not in result, "Included malformed row (Breakthru)"

    print("✅ All log grouping tests passed!")

if __name__ == "__main__":
    run_tests()