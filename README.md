# KingOfDiamonds
 A mathematical game inspired by Alice in Borderland.
 
 ## How to play
 There are five inputs, each one accepting only an integer value from 0 to 100. The winner of the round is determined by the result of: 
 
 `
 Multiplying the average by 0.8
`

 The player who gets closer to this result will not have its points reduced, however, the others will lose `-1` point.
 
 Each player starts with `0 points` and the game will be over to the one who reaches `-10`. The game will end up when there is only one player left.
 
 
 `A new rule is introduced for every player eliminated.`
 
 ## RULES ##
 ### **4** players remaining:

If 2 players or more choose the `same number`, the number becomes `invalid`, resulting in a point deduction even if their moves are closer to the result.

 ### **3** players remaining:
 
If a player chooses the `exact correct number`, the losers penalty is `doubled (-2)`.

 ### **2** players remaining:
 
If someone chooses `0`, the player who chooses `100` is the winner.
