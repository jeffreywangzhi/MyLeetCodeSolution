"""
SANTÉ ENGINEERING INTERVIEW: REFERENCE SOLUTION
Problem: The POS Cart Calculator
"""

from collections import Counter
from decimal import Decimal
from typing import List, Dict, Any

def calculate_receipt_total(scanned_ids: List[str], catalog: Dict[str, Dict[str, Any]]) -> Decimal:
    # Use Counter to group the raw stream into O(1) frequency lookups
    item_counts = Counter(scanned_ids)
    
    total = Decimal("0.00")
    deposit_fee = Decimal("0.05")

    for sku, count in item_counts.items():
        # Defensive lookup: ignore items not in the catalog
        if sku not in catalog:
            continue
            
        item = catalog[sku]
        
        # 1. Base Price
        base_price = Decimal(item["price"])
        item_subtotal = base_price * count
        
        # 2. Bottle Deposit
        if item.get("is_deposit_eligible", False):
            item_subtotal += deposit_fee * count
            
        # 3. Case Discount (applied per full case of 12)
        if "case_discount" in item:
            discount = Decimal(item["case_discount"])
            full_cases = count // 12
            item_subtotal -= discount * full_cases
            
        total += item_subtotal
        
    return total

# =====================================================================
# TEST RUNNER
# =====================================================================
def run_tests():
    catalog = {
        "SKU_TITO_750": {
            "price": "20.00",
            "is_deposit_eligible": True,
            "case_discount": "5.00"
        },
        "SKU_WINE_CAB": {
            "price": "15.00",
            "is_deposit_eligible": False,
            "case_discount": "10.00"
        },
        "SKU_SODA_CAN": {
            "price": "1.50",
            "is_deposit_eligible": True
        }
    }

    scans_1 = ["SKU_TITO_750", "SKU_WINE_CAB"]
    assert calculate_receipt_total(scans_1, catalog) == Decimal("35.05"), "Test 1 Failed"

    scans_2 = ["SKU_WINE_CAB"] * 13
    assert calculate_receipt_total(scans_2, catalog) == Decimal("185.00"), "Test 2 Failed"

    scans_3 = ["SKU_TITO_750"] * 25 + ["INVALID_BARCODE_1", "SKU_SODA_CAN", "UNKNOWN_SKU"]
    assert calculate_receipt_total(scans_3, catalog) == Decimal("492.80"), "Test 3 Failed"

    print("✅ All cart calculator tests passed!")

if __name__ == "__main__":
    run_tests()