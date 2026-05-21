package br.com.kadson.databaseExercise.exemplo_internet.springdata.multistore.shop;

import lombok.Data;

@Data
//@RequiredArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class LineItem {

    private final String caption;
    private final double price;

    int quantity = 1;

    public LineItem(String caption, double price) {
        this.caption = caption;
        this.price = price;
    }

    public LineItem(String caption, double price, int quantity) {
        this(caption, price);
        this.quantity = quantity;
    }
}
