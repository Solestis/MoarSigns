package gory_moon.moarsigns.client.interfaces.buttons;

import gory_moon.moarsigns.client.interfaces.GuiBase;
import gory_moon.moarsigns.client.interfaces.GuiColor;
import gory_moon.moarsigns.client.interfaces.GuiMoarSign;

public class ButtonPasteSign extends GuiButton {

    public ButtonPasteSign(int x, int y) {
        super(x, y, 80);
    }

    @Override
    public String getButtonInfo() {
        return "Paste Sign\n" + GuiColor.GRAY + "Pastes all text from a sign\n" + GuiColor.GRAY + "that is in the clipboard";
    }

    @Override
    public void action(GuiBase gui) {
        GuiMoarSign guiM = (GuiMoarSign)gui;

        String s = guiM.getClipboardContent();
        boolean signPaste = (!s.equals("") && s.length() > 8 && s.substring(0, 8).equals("moarsign") && s.split(":").length == 6);
        if (signPaste) {
            String[] rows = s.split(":");
            for (int i = 1; i < rows.length - 1; i++) {
                guiM.guiTextFields[i - 1].setText(rows[i]);
            }
        }
    }

    @Override
    public void update(GuiMoarSign gui) {
        String clip = gui.getClipboardContent();
        isDisabled = !(!clip.equals("") && clip.length() > 8 && clip.substring(0, 8).equals("moarsign") && clip.split(":").length == 6);
    }
}
