import java.util.ArrayList;
import java.util.Scanner;

public class Uno
{
  Deck cards = new Deck();
  
  Scanner sc = new Scanner(System.in);
  int chosenIndex;
  Card cardOnPlay;
  Player playerOne;
  Player playerTwo;
  ArrayList<Card> playedCards;
  
  private boolean hasColour( Player player )
  {
    for( Card eachCard: player.getCardsInHand() )
    {
      if(eachCard.getColour().equals(cardOnPlay.getColour()))
      {
        return true;
      }
    }
    return false;
  }
  
  private boolean hasValue(Player player)
  {
    for( Card eachCard: player.getCardsInHand() )
    {
      if( eachCard.getValue().equals(cardOnPlay.getValue()) )
      {
        return true;
      }
    }
    return false;
  }
  
  public void drawIfNoMatch(Player player)
  {
    Card draw;
    String userInput;
    
    while(!hasColour(player) && !hasValue(player))
    {
      System.out.println("You don't have any card which matches the colour or number. Enter D to draw a card: ");
      userInput = sc.next();
      
      if( userInput.toLowerCase().equals("d") )
      {
        draw = cards.drawCard();
        player.addCardToHand(draw);
        System.out.print("\nYou have got: " + draw);
        System.out.println(" and the card on play is: " + cardOnPlay + ".\n");
        display(player);
      }
      
      else
      {
        System.out.println("Enter D to draw a card");
      }
    }
  }
  
  public void promptUser (Player player)
  {
    int choice = 0;
    System.out.print("Choose a card you want to play: ");
    while( !sc.hasNextInt() )
    {
      System.out.println("You don't have " + (choice + 1) + " cards. Please enter a valid choice: ");
      while( !sc.hasNextInt() )
      {
        System.out.println("Your choice must be an integer value. Please enter again: ");
        sc.next();
      }
      choice = sc.nextInt() - 1;
    }
    chosenIndex = choice;
  }
  
  public boolean match( Player player, int choice )
  {
    if( player.getSpecificCard(choice).getColour().equals(cardOnPlay.getColour()) || player.getSpecificCard(choice).getValue().equals(cardOnPlay.getValue()) )
    {
      return true;
    }
    return false;
  }
  
  public void display(Player player)
  {
    System.out.println(player + ", it's your turn!");
    System.out.println("Your cards are : \n");
    player.printCardsInHand();
  }
  
  public void pauseSpace()
  {
    for( int i = 0; i < 30; i++ )
    {
      System.out.println();
    }
    
    while(sc.nextLine() == " ")
    {
      System.out.println("Press Space to create a pause: ");
    }
    
    do
    {
      System.out.println("Press Enter to start next turn: ");
    }
    while(sc.nextLine() == "");
  }
  
  public void round(Player player)
  {
    Card playedCard;
    System.out.println("The card on play is: " + cardOnPlay + ".\n");
    display(player);
    drawIfNoMatch(player);
    promptUser(player);
    
    while( !match(player, chosenIndex) )
    {
      System.out.println("The card you choose has to be the same colour or number! Try again: ");
      chosenIndex = sc.nextInt() - 1;
    }
    
    playedCard = player.playCard(chosenIndex);
    player.checkUno();
    cardOnPlay = playedCard;
    playedCards.add(cardOnPlay);
    
    while( cards.checkEmpty() )
    {
      cards.restoreDeck(playedCards);
      cards.shuffle();
    }
    pauseSpace();
  }
  
  public void endGame(Player mainPlayer, Player otherPlayer)
  {
    if( otherPlayer.checkWin() == false )
    {
      round(mainPlayer);
    }
    
    if( mainPlayer.checkWin() == true )
    {
      System.out.println(mainPlayer + " WINS!");
    }
  }
  
  public void unoForTwo()
  {
    int loop = 1;
    while( loop == 1 )
    {
      if( playerOne.checkWin() == false && playerTwo.checkWin() == false )
      {
        endGame( playerOne, playerTwo );
      }
      
      if( playerOne.checkWin() == false && playerTwo.checkWin() == false )
      {
        endGame( playerTwo, playerOne );
      }
    }
  }
}