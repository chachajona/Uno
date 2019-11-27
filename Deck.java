import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  private ArrayList<Card> cards;
  
  public Deck()
  {
    this.cards = new ArrayList<Card>();
  }
  
  public void fillDeck()
  {
    for( int i = 0; i< Colour.values().length; i++ )
    {
      for( int n = 0; n < 2; n++)
      {
        for( int j = 0; j < Value.values().length - 1; j++)
        {
          this.cards.add( new Card(Colour.values()[i], Value.values()[j]) );
        }
      }
    }
    
    for( int i = 0; i < Colour.values().length; i++ )
    {
      this.cards.add( new Card ( Colour.values()[i], Value.ZERO) );
    }
  }
  
  public void shuffle()
  {
    Collections.shuffle(cards);
  }
  
  public Card drawCard()
  {
    return cards.remove( cards.size() - 1 );
  }
  
  public boolean checkEmpty()
  {
    if( cards.size() == 0 )
    {
      return true;
    }
    return false;
  }
  
  public void restoreDeck(ArrayList<Card> playedCards)
  {
    int restoreCardsSize = playedCards.size();
    for( int i = 0; i < restoreCardsSize; i++)
    {
      this.cards.add( playedCards.get(i) );
    }
    for(int i = 0; i < restoreCardsSize; i++)
    {
      playedCards.remove(i);
    }
  }
}