
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;


public class HFJ {

    public HFJ() {
    }
    

    

    public static void main(String[] args) {
           HFJ t = new HFJ();
           t.go();
    }

    private void go() {
        try {
            Sequencer seq = MidiSystem.getSequencer();
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }

   
}
