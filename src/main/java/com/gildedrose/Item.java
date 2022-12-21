package com.gildedrose;

public class Item {
    public final static  String AGED_BRIE="Aged Brie";
    public final static  String  SULFURAS="Sulfuras, Hand of Ragnaros";
    public final static  String  BACKSTAGE="Backstage passes to a TAFKAL80ETC concert";
    public final static  String CAKE="Conjured Mana Cake";
  
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
    
    /**
     * 
     */
    public void updateQuality() {
        if(this.name.equals(SULFURAS)) {
            return;
        }

            this.sellIn--;

        switch(this.name){
            case AGED_BRIE:
                  this.quality++;
                  if( this.sellIn<0){
                    this.quality++;
                      }
            break;
            case BACKSTAGE:
              
                    this.quality++;
                    if( this.sellIn<10){
                        this.quality++;
                    }
                    if( this.sellIn<5){
                        this.quality++;
                    }
                    if( this.sellIn<0){
                        this.quality=0;
                    } 
                
            break;
            case CAKE:
                  if(this.sellIn<0){
                    this.quality-=4;
                  }else{
                    this.quality-=2;
                  }
            break;
                
            default :
                    if(this.sellIn<0){
                        this.quality-=2;
                    }else{
                        this.quality-=1;
                            }
            break; 
                    
           
            }
            testQuality();
               
    }
    private void testQuality(){
        if(this.quality>50){
            this.quality=50;
                    }  
        if(this.quality<0){
            this.quality=0;
    }

    }
}

