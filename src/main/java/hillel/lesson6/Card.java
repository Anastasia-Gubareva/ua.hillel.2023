package hillel.lesson6;

import java.util.Objects;

public class Card {
        private final String suit;
        private final String value;

        public Card(String suit, String value) {
            this.suit = suit;
            this.value = value;
        }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) && Objects.equals(value, card.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

