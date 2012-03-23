package com.wunkoteam.testing.testproj;

import static android.media.AudioManager.STREAM_NOTIFICATION;
import static android.media.AudioManager.STREAM_RING;
import static android.media.AudioManager.STREAM_SYSTEM;

import java.util.HashMap;
import java.util.Locale; 
import android.app.Service; 
import android.content.Context;
import android.content.Intent; 
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.os.IBinder; 
import android.provider.MediaStore.Audio.Media;
import android.speech.tts.TextToSpeech; 
import android.speech.tts.TextToSpeech.OnInitListener; 
import android.util.Log; 
import android.widget.Toast; 
public class SpeakerService extends Service implements OnInitListener { 
		AudioManager mAudioManager;
		private int mSysVol = 100;
		RingtoneManager rm;
		String sTTStest = "I am now Testing speech";
	
    
		public TextToSpeech mtts; 
        //Context mContext = getApplicationContext(); 
        @Override 
        public IBinder onBind(Intent arg0) { 
                // TODO Auto-generated method stub
        	Log.d("SpeakerService","Entered onBind Method"); 
                return null; 
        } 
        @Override 
        public void onCreate(){ 
                Log.d("SpeakerService","Service created successfully!"); 
               // mtts = new TextToSpeech(getApplicationContext(),this); 
               
                
               // mtts = new TextToSpeech(this.getBaseContext(),this);
                rm = new RingtoneManager(getApplicationContext());
                
               mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
               
        } 
        @Override 
        public void onStart(Intent intent,int startid) 
        { 		
                
        	Context context = getApplicationContext();
        	TtsProviderFactory ttsProviderImpl = TtsProviderFactory.getInstance();
        	if (ttsProviderImpl != null) {
        	    ttsProviderImpl.init(context);
        	    ttsProviderImpl.say("hope that helps");}
        	
        	
        	
        	
        	
        	
        	/*Log.d("SpeakerService","Service started successfully!");
                //mtts = new TextToSpeech(getApplicationContext(),this);
                
                mtts = new TextToSpeech(this.getBaseContext(),this);
                mtts.setLanguage(Locale.ENGLISH);
                
                mSysVol = mAudioManager.getStreamMaxVolume(STREAM_SYSTEM);
                Log.d("SpeakerService","Max STREAM_SYSTEM: ");
                
                Log.d("SpeakerService","getting ready to call 'saySomething' method");
                saySomething();
                
                 mAudioManager.setStreamMute(STREAM_SYSTEM, false);
                mAudioManager.setStreamVolume(STREAM_SYSTEM, mSysVol, 0);
                 //, this is actually a really long speech scnetence to see wherther i am speaking or not
                //mtts.speak("i am now Testing speech", TextToSpeech.QUEUE_FLUSH,null); 
                //Toast.makeText(mContext,"YO, im speaking!!", Toast.LENGTH_LONG).show(); 
                Log.d("SpeakerService","synthesis done successfully"); */
        } 
        private void saySomething() {
			// TODO Auto-generated method stub
        	Log.d("SpeakerService","Entered 'saySomething' method");
        	 HashMap<String, String> myHashAlarm = new HashMap<String, String>();

             myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_STREAM, String.valueOf(AudioManager.STREAM_NOTIFICATION));
             myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "test");
        	
             
             mtts.speak(sTTStest, TextToSpeech.QUEUE_ADD,myHashAlarm); 
        	
		}
		
        
        @Override 
        public void onDestroy(){ 
               
        	
        	Log.d("SpeakerService","onDestroy method entered.");
			
			        // Don't forget to shutdown!
			        if (mtts != null) {
			            mtts.stop();
			            mtts.shutdown();
			            Log.d("SpeakerService","Service Stopped.");
			        }

			        super.onDestroy();
			        Log.d("SpeakerService","Service Destroyed!");
			    
                                

               
        }
		@Override
		public void onInit(int status) {
			// TODO Auto-generated method stub
			
			
			 Log.d("SpeakerService","Entered onInit Method"); 
			// mtts.setLanguage(Locale.ENGLISH);
		}
		
       
        
} 

/*
import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SpeakerService extends Service {

PhoneReceiver prv = new PhoneReceiver();
TextToSpeech mtts = new TextToSpeech(getApplicationContext(), null);
//public TextToSpeech mtts;
@Override
public IBinder onBind(Intent arg0) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void onCreate(){
    //mtts =new TextToSpeech(getBaseContext(), null);
    Log.d("SpeakerService","Service created successfully!");
    //mtts.speak(rv.str, TextToSpeech.QUEUE_FLUSH,null);

}
@Override
public void onStart(Intent intent,int startid)
{
    Log.d("SpeakerService","Service started successfully!");
    mtts.speak("this is test speech", TextToSpeech.QUEUE_FLUSH,null);
}
@Override
public void onDestroy(){
    if(mtts!=null)
    {
        mtts.stop();
        Toast.makeText(getApplicationContext(),"The service has been destroyed!", Toast.LENGTH_SHORT).show();
    }

}
}*/