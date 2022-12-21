package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test that the quality will decrement")
  void testdecrementation() {
    Item[] items = new Item[] {new Item("boo", 2, 0),
    new Item("foo", 2, 6),
    new Item(Item.CAKE, -1, 49),
    new Item(Item.CAKE, 0, 49),
    new Item(Item.CAKE, 1, 49),
    new Item("boo", -1, 0)
  };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
  
    assertThat(app.items[0].quality, is(0));
    assertThat(app.items[1].quality, is(5));
    assertThat(app.items[2].quality, is(45));
    assertThat(app.items[3].quality, is(45));
    assertThat(app.items[4].quality, is(47));
    assertThat(app.items[5].quality, is(0));

}


@Test
@DisplayName("Test  quality increases as time goes by")
void quality_increases_in_time() {
  Item[] items = new Item[] {new Item(Item.AGED_BRIE, 2, 0),
    new Item(Item.AGED_BRIE, 2, 50),
    new Item(Item.BACKSTAGE, 4, 44),
    new Item(Item.SULFURAS, 0, 50),
    new Item(Item.AGED_BRIE, 0, 2),
    new Item(Item.BACKSTAGE, 11, 17),
    new Item(Item.BACKSTAGE, 0, 49),
    new Item(Item.SULFURAS, 0, 40),
    new Item(Item.AGED_BRIE, 1, 40),
    new Item(Item.SULFURAS, -1, 49),
      
    };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(1));
    assertThat(app.items[1].quality, is(50));
    assertThat(app.items[2].quality, is(47));
    assertThat(app.items[3].quality, is(50));
    assertThat(app.items[4].quality, is(4));
    assertThat(app.items[4].sellIn, is(-1));
    assertThat(app.items[5].quality, is(18));
    assertThat(app.items[6].quality, is(0));
    assertThat(app.items[7].quality, is(40));
    assertThat(app.items[8].quality, is(41));
    assertThat(app.items[9].quality, is(49));
    
}

@Test
  @DisplayName("Test tostring")
  void testtostring() 
  {
      Item element =  new Item ("Aged Brie",0,40  );
      assertThat(element.toString(), is("Aged Brie, 0, 40"));
   
    }

}
