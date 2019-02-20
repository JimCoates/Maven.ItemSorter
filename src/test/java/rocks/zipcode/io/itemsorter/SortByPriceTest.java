package rocks.zipcode.io.itemsorter;

import org.junit.Assert;
import org.junit.Test;
import rocks.zipcode.io.Item;
import rocks.zipcode.io.ItemSorter;
import rocks.zipcode.io.comparators.IdComparator;
import rocks.zipcode.io.comparators.PriceComparator;

import java.util.Comparator;

/**
 * @author leon on 30/01/2019.
 */
public class SortByPriceTest {

    @Test
    public void test1() {
        // given
        Item item3 = new Item(30L, "Bailey", 12.0);
        Item item2 = new Item(21L, "Ghost", 14.5);
        Item item1 = new Item(2L, "Eric", 22.0);

        Item[] itemsToSort = {item2, item1, item3};
        Item[] expected = {item3, item2, item1};
        ItemSorter itemSorter = new ItemSorter(itemsToSort);
        Comparator<Item> comparator = (Comparator<Item>) new PriceComparator();

        // when
        Item[] actual = itemSorter.sort(comparator);

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        // given
        Item item3 = new Item(24L, "Tim", 11.0);
        Item item2 = new Item(24L, "Kelly", 1.5);
        Item item1 = new Item(35L, "George", 2.0);

        Item[] itemsToSort = {item2, item1, item3};
        Item[] expected = {item2, item1, item3};
        ItemSorter itemSorter = new ItemSorter(itemsToSort);
        Comparator<Item> comparator = (Comparator<Item>) new PriceComparator();

        // when
        Item[] actual = itemSorter.sort(comparator);

        // then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        // given
        Item item3 = new Item(10L, "Coffe", 11.0);
        Item item2 = new Item(15L, "Bravo", 11.5);
        Item item1 = new Item(16L, "Delta", 2.0);

        Item[] itemsToSort = {item2, item1, item3};
        Item[] expected = {item1, item3, item2};
        ItemSorter itemSorter = new ItemSorter(itemsToSort);
        Comparator<Item> comparator = (Comparator<Item>) new PriceComparator();

        // when
        Item[] actual = itemSorter.sort(comparator);

        // then
        Assert.assertArrayEquals(expected, actual);
    }
}
