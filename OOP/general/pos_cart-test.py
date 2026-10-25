"""
SANTÉ ENGINEERING INTERVIEW: CODING ARCHETYPE A
Problem: The POS Cart Calculator

CONTEXT:
You are building the checkout logic for a physical liquor store point-of-sale (POS) terminal. 
When a cashier scans items, the barcode scanner sends a raw stream of string SKUs. 

YOUR TASK:
Write a function that calculates the final receipt total for a list of scanned SKUs 
based on a product catalog.

BUSINESS RULES:
1. Base Price: Each valid scanned item adds its catalog price to the total.
2. Missing Items: If a scanned SKU does not exist in the catalog, ignore it (the cashier 
   scanned an unregistered barcode).
3. State Bottle Deposit: If the catalog marks the item as `is_deposit_eligible: True`, 
   add a flat $0.05 fee per bottle.
4. Case Discounts: If a customer buys a full case (12 bottles) of the EXACT SAME item, 
   subtract the item's `case_discount` from the total for every full case purchased. 
   (e.g., buying 25 bottles = 2 full cases = 2x discount).
5. Precision: Return the final total as a `Decimal`. Never use floating-point math for currency.
"""

from decimal import Decimal
from typing import List, Dict, Any
from collections import Counter

def calculate_receipt_total(scanned_ids: List[str], catalog: Dict[str, Dict[str, Any]]) -> Decimal:
    res = Decimal(0)
    count = Counter(scanned_ids)

    for sku, c in count.items():
        if sku not in catalog: continue
        cal = Decimal(catalog[sku]["price"])*c
        if catalog[sku]["is_deposit_eligible"]: cal += Decimal("0.05")*c
        if "case_discount" in catalog[sku]:
            dis = c//12*Decimal(catalog[sku]["case_discount"])
            cal -= dis
        res += cal
    return res


# =====================================================================
# TEST RUNNER
# =====================================================================
def run_tests():
    catalog = {
        "SKU_TITO_750": {
            "price": "20.00",
            "is_deposit_eligible": True,
            "case_discount": "5.00"  # $5 off per 12 bottles
        },
        "SKU_WINE_CAB": {
            "price": "15.00",
            "is_deposit_eligible": False,
            "case_discount": "10.00" # $10 off per 12 bottles
        },
        "SKU_SODA_CAN": {
            "price": "1.50",
            "is_deposit_eligible": True
            # No case discount available
        }
    }

    # Test 1: Simple single items
    # Tito: 20.00 + 0.05 = 20.05
    # Wine: 15.00
    # Total: 35.05
    scans_1 = ["SKU_TITO_750", "SKU_WINE_CAB"]
    assert calculate_receipt_total(scans_1, catalog) == Decimal("35.05"), "Test 1 Failed"

    # Test 2: Case discount trigger
    # 13 bottles of Wine = (13 * 15.00) = 195.00
    # 1 full case discount = -10.00
    # Total: 185.00
    scans_2 = ["SKU_WINE_CAB"] * 13
    assert calculate_receipt_total(scans_2, catalog) == Decimal("185.00"), "Test 2 Failed"

    # Test 3: Complex cart with missing/invalid SKUs
    # 25 bottles of Tito = (25 * 20.00) = 500.00
    # Deposits = 25 * 0.05 = 1.25
    # Case discounts = 2 cases * 5.00 = -10.00
    # Tito Subtotal = 491.25
    # 1 Soda = 1.50 + 0.05 = 1.55
    # Invalid SKUs = 0.00
    # Total: 492.80
    scans_3 = (
        ["SKU_TITO_750"] * 25 + 
        ["INVALID_BARCODE_1", "SKU_SODA_CAN", "UNKNOWN_SKU"]
    )
    assert calculate_receipt_total(scans_3, catalog) == Decimal("492.80"), "Test 3 Failed"

    print("✅ All cart calculator tests passed!")

if __name__ == "__main__":
    run_tests()