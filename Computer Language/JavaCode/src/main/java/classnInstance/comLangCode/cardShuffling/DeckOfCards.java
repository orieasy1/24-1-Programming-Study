package classnInstance.comLangCode.cardShuffling;

import java.security.SecureRandom;

public class DeckOfCards {
    private static final SecureRandom random = new SecureRandom();
    private static final int cardNum = 52;

    private Card[] deck = new Card[cardNum];
    private int currentCard = 0;

    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "3", "4", "5", "6", "7", "8","9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        //faces와 suits 바탕으로 카드생성
        for(int i =0; i < deck.length; i++){
            deck[i] = new Card(faces[i % 13], suits[i / 13]);
        }
    }

    public void shuffle() {
        currentCard = 0;

        for(int i = 0; i < deck.length; i++) {
            //i위치에 있는 카드를 무작위로 선택된 j위치의 카드와 교환하는 것
            int j = random.nextInt(cardNum);

            //섞기
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // return current Card in array
        }
        else {
            return null; // return null to indicate that all Cards were dealt
        }
    }
}
