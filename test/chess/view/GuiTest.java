package chess.view;

import org.junit.jupiter.api.Test;

import view.Gui;

public class GuiTest {
	
	
	@Test
	public void guiInitializes() {
		Gui gui = new Gui();
		gui.initializeGui();
	}
}
