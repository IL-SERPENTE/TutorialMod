package fr.scarex.tutorialmod.core;

import java.util.List;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import fr.scarex.tutorialmod.TutorialMod;

/**
 * @author SCAREX
 *
 */
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class TutorialModLoadingPlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass() {
		return new String[] {
				TutorialModClassTransformer.class.getName() };
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
