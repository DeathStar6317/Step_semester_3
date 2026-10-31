
public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;

        if (capacity < 0) {
            capacity = 0;
        }

        prices = new double[capacity];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (price <= 0) {
            System.out.println("Price must be positive");
            return;
        }

        if (itemCount >= prices.length) {
            System.out.println("Cart is full");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
