public class Card
{
  private Colour colour;
  private Value value;
  //private Symbol symbol;
  
  /*public Card( Colour colour, Symbol symbol) 
  {
    this.colour = colour;
    this.symbol = symbol;
  }*/
  
  public Card( Colour colour, Value value )
  {
    this.colour = colour;
    this.value = value;
  }
  
  public Colour getColour()
  {
    return colour;
  }
  
  public Value getValue()
  {
    return value;
  }
  
  public String toString()
  {
    return this.colour.toString() + "-" + this.value.toString();
  }
}