package com.inventory.catWannaEat.models;

import java.time.LocalDateTime;

public class FoodBag {
   private long foodBagId;
   private Food foodType;
   private long amount;
   private LocalDateTime packingDate;

   public FoodBag(Food foodType) {
      this.foodType = foodType;
      this.packingDate = LocalDateTime.now();
   }

   public long getFoodBagId() {
      return foodBagId;
   }

   public void setFoodBagId(long foodBagId) {
      this.foodBagId = foodBagId;
   }

   public Food getFoodType() {
      return foodType;
   }

   public void setFoodType(Food foodType) {
      this.foodType = foodType;
   }

   public long getAmount() {
      return amount;
   }

   public void setAmount(long amount) {
      this.amount = amount;
   }

   public LocalDateTime getPackingDate() {
      return packingDate;
   }

   public void setPackingDate(LocalDateTime packingDate) {
      this.packingDate = packingDate;
   }
}
