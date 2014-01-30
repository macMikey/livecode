/* Copyright (C) 2003-2013 Runtime Revolution Ltd.
 
 This file is part of LiveCode.
 
 LiveCode is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License v3 as published by the Free
 Software Foundation.
 
 LiveCode is distributed in the hope that it will be useful, but WITHOUT ANY
 WARRANTY; without even the implied warranty of MERCHANTABILITY or
 FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 for more details.
 
 You should have received a copy of the GNU General Public License
 along with LiveCode.  If not see <http://www.gnu.org/licenses/>.  */

package com.runrev.android.billing;

import java.util.*;
import android.content.*;

public interface BillingProvider
{
    
    // Determine whether the store is available and purchases can be made
    boolean canMakePurchase();
    
    // Allow the store to send purchase updates to the engine
    boolean enableUpdates();
    
    // Prevent the store from sending purchase state updates to the engine
    boolean disableUpdates();
    
    // Begin a purchase restoration operation to reenable previously purchased items
    boolean restorePurchases();
    
    // Create and send a new purchase request identified by the given id and using the given properties
    boolean sendRequest(int purchaseId, String productId, Map<String, String> properties);
    
    // Consume a purchased item -- only for Google API
    boolean consumePurchase(String productId);
    
    // Return the set of properties for the given id. These should be updated with any information returned by the store (receipt, etc.)
    Map<String, String> getPurchaseProperties(int purchaseId);
    
    // Notify the store that the item has been delivered
    boolean confirmDelivery(int purchaseId);
    
    // Register an observer for any updates to purchase requests
    void setPurchaseObserver(PurchaseObserver observer);

    // Initialize the store
    void initBilling();
    
    // helper
    void onActivityResult (int requestCode, int resultCode, Intent data);
    
}