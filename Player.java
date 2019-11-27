import java.util.ArrayList;

public class Player
{
  private ArrayList<Card> cardsInHand;
  private String playerName;
  
  public Player(String name)
  {
    this.cardsInHand = new ArrayList<Card>();
    this.playerName = name;
  }
  
  public ArrayList<Card> getCardsInHand()
  {
    return cardsInHand;
  }
  
  public Card getSpecificCard( int choice )
  {
    return cardsInHand.get(choice);
  }
  
  public void addCardToHand( Card aCard)
  {
    cardsInHand.add(aCard);
  }
  
  public Card playCard( int index )
  {
    return cardsInHand.remove( index );
  }
  
  public void checkUno()
  {
    if( cardsInHand.size() == 1)
    {
      System.out.println("\n" + playerName + "says >>UNO<< ");
    }
  }
  
  public boolean checkWin()
  {
    if( cardsInHand.size() == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public void printCardsInHand()
  {
    for( int i = 0; i < cardsInHand.size(); i++ )
    {
      System.out.println((i+1) + " " + cardsInHand.get(i).getColour() + "-" + cardsInHand.get(i).getValue() + "\n");
    }
  }
  
  public String toString()
  {
    return this.playerName;
  }
}