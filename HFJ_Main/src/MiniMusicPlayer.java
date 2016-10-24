
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer implements ControllerEventListener {

    public static void main(String[] args) {
        MiniMusicPlayer m = new MiniMusicPlayer();

        m.go();
    }

    private void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            int[] eventIWant = {127};
            sequencer.addControllerEventListener(this, eventIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i += 4) {
                track.add(makeEvent(144, 1, i, 100, i));
                
                track.add(makeEvent(176,1,127,1,i));
                               
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception ex) {
            Logger.getLogger(MiniMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println(event);
    }

}
