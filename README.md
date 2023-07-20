# KingOfDiamonds
 A mathematical game inspired by Alice in Borderland.
 
 ## How to play
 There are five inputs, each one can accept only an int value from 0 to 100. The winner of the round will be determined by the result of  
 `
 Multiplying the average by 0.8
`


 The player who gets closer to this result will not have its points reduced `-1`, while the others will. 
 
 Each player will start with `0 points`, will be gameover to the one who reaches `-10`. The game will end up when there is only one player left.
 
 
 `A new rule is introduced for every player eliminated.`
 
 ## RULES ##
 ### **4** players remaining:

If 2 players or more choose the `same number`, the number becomes `invalid`, which means they will lose a point even if their moves are closer to the result.


 ### **3** players remaining:
 
 If there is a player who chooses the `exact correct number`, the losers penalty is `doubled`.
 
 
 ### **2** players remaining:
 
 If someone chooses `0`, the player who chooses `100` is the winner.
