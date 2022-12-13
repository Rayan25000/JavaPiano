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

    public int convertJBTextIntoNumber(String text){
        int res =0;
        if(text.equals("DO"))
            res = 60;
        else if(text.equals("RE"))
            res = 62;
        else if(text.equals("MI"))
            res = 64;
        else if(text.equals("FA"))
            res = 65;
        else if(text.equals("SOL"))
            res = 67;
        return res;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playNote(convertJBTextIntoNumber(this.getText()),1);
    }





}
