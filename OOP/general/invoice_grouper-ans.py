"""
SANTÉ ENGINEERING INTERVIEW: REFERENCE SOLUTION
Problem: Invoice Log Grouping & Aggregation
"""

from typing import List, Dict
from collections import defaultdict

def group_invoice_logs(logs: List[str]) -> Dict[str, Dict[str, int]]:
    # Use a nested defaultdict to handle missing keys automatically in O(1) time
    aggregated = defaultdict(lambda: defaultdict(int))
    
    for log in logs:
        # Guard against empty or completely malformed strings
        if not log or not log.strip():
            continue
            
        parts = log.split(",")
        
        # Rule 4: Ignore if not exactly 3 columns
        if len(parts) != 3:
            continue
            
        # Rule 2: Strip whitespace
        vendor = parts[0].strip()
        item = parts[1].strip()
        raw_qty = parts[2].strip()
        
        # Rule 3 & 4: Validate prefix and parse integer
        if not raw_qty.startswith("qty_"):
            continue
            
        qty_str = raw_qty.replace("qty_", "")
        
        try:
            qty = int(qty_str)
        except ValueError:
            # Ignore row if the amount is not a valid integer (e.g., 'abc')
            continue
            
        # Aggregate the quantity safely
        aggregated[vendor][item] += qty
        
    # Convert back to standard dicts for clean return boundaries (optional but preferred)
    return {v: dict(items) for v, items in aggregated.items()}


# =====================================================================
# TEST RUNNER
# =====================================================================
def run_tests():
    raw_logs = [
        "Southern Glazers,Titos 750ml,qty_12",
        "RNDC,Macallan 12,qty_6",
        "Southern Glazers,Titos 750ml,qty_24",
        "Southern Glazers,Casamigos Blanco,qty_12",
        "  RNDC , Macallan 12 , qty_6  ",
        "Empire Merchants,MissingQtyCol",
        "Empire Merchants,Highland Park,12",          
        "Breakthru,Grey Goose,qty_abc",               
        "",                                           
    ]

    result = group_invoice_logs(raw_logs)

    assert "Southern Glazers" in result
    assert result["Southern Glazers"]["Titos 750ml"] == 36
    assert result["Southern Glazers"]["Casamigos Blanco"] == 12

    assert "RNDC" in result
    assert result["RNDC"]["Macallan 12"] == 12

    assert "Empire Merchants" not in result
    assert "Breakthru" not in result

    print("✅ All log grouping tests passed!")

if __name__ == "__main__":
    run_tests()