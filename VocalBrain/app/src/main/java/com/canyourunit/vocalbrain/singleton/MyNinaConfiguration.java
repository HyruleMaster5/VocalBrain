package com.canyourunit.vocalbrain.singleton;

import com.canyourunit.vocalbrain.VocalBrain;
import com.nuance.nina.configurations.NinaSetup;
import com.nuance.nina.mmf.MMFController;
import com.nuance.nina.mmf.NinaConfiguration;

public class MyNinaConfiguration {
    private static MyNinaConfiguration instance;
    public static MyNinaConfiguration getInstance(){
        if (instance == null){
            instance = new MyNinaConfiguration();
        }
        return instance;
    }

    private MyNinaConfiguration() {
        NinaConfiguration config = MMFController.getInstance().getNinaConfiguration();
        config.setGatewayApplicationId(NinaSetup.getNmaidId());
        config.setGatewayApplicationKey(NinaSetup.getNmaidKey());

        config.setAdkApplicationName("NinaCloud");
        config.setGatewayAddress("nim-rd.nuance.mobi", 443);
        config.setTtsDefaultVoice("Samantha");
        MMFController.getInstance().connect(VocalBrain.getAppContext(), NinaSetup.getCloudApplicationInfo());
    }
}