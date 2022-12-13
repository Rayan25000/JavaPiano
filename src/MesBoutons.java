import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MesBoutons extends JButton implements ActionListener {

    public MesBoutons(){
        super();
        initBouton();
    }
    public MesBoutons(String titre) {
        super(titre);
        initBouton();
    }

    public void initBouton(){
        this.addActionListener(this);
    }

    public void playNote(int finalNote, int finalInstrument) {

        new Thread(new Runnable() {

            @Override

            public void run() {

                try {

                    Synthesizer synth = MidiSystem.getSynthesizer();

                    synth.open();

                    MidiChannel[] channels = synth.getChannels();

                    channels[1].programChange(finalInstrument);

                    channels[1].noteOn(finalNote, 100);

                    Thread.sleep(1000);

                    channels[1].noteOff(finalNote);

                } catch (MidiUnavailableException | InterruptedException ex) {

                    ex.printStackTrace();

                }

            }

        }).start();

    }

    public void convertJBTextIntoNumber(){
        String[] tab = new String[]{"DO","RE","MI","FA", "SOL"};
        Map<String,String> notes = new HashMap<String,String>();
        notes.put("60","DO");
        notes.put("62","RE");
        notes.put("64","MI");
        notes.put("65","FA");
        notes.put("67","SOL");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("je suis le bouton " + this.getText() + " et je suis pressé eheh");
        //playNote();
    }





}
