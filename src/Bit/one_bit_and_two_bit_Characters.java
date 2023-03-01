package Bit;
/**
 717. 1-bit and 2-bit Characters
 **/
public class one_bit_and_two_bit_Characters {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i< bits.length-1; i++){
            if(bits[i] == 1){
                i++;
            }
            if(i == bits.length-1) return false;
        }
        return true;
    }
}
