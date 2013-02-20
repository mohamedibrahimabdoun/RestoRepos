package groupbutton.pkg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GRadioButtonActivity extends Activity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{
    /** Called when the activity is first created. */
	RadioGroup rg;
	Button Show,Clear;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        rg=(RadioGroup) findViewById(R.id.radiogroup);
        rg.setOnCheckedChangeListener(this);
        RadioButton first=(RadioButton) findViewById(R.id.radio1);
        RadioButton second=(RadioButton) findViewById(R.id.radio2);
        RadioButton third=(RadioButton) findViewById(R.id.radio3);
         Show=(Button) findViewById(R.id.show);
         Clear=(Button) findViewById(R.id.clear);
         Show.setOnClickListener(this);
         Clear.setOnClickListener(this);

    }
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
	
		if (checkedId==R.id.radio1)
		{
			Toast.makeText(getBaseContext(), "U have click the first", Toast.LENGTH_LONG).show();
		}
		else if (checkedId==R.id.radio2)
		{
			Toast.makeText(getBaseContext(), "U have click the second", Toast.LENGTH_LONG).show();
		}
		else if (checkedId==R.id.radio3)
		{
			Toast.makeText(getBaseContext(), "U have click the third", Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.clear)
		{
			rg.clearCheck();
			Toast.makeText(getBaseContext(), "U have click the clear Radio", Toast.LENGTH_LONG).show();
		}
		else if(v.getId()==R.id.show)
		{
			Toast.makeText(getBaseContext(), "U have click the show", Toast.LENGTH_LONG).show();
		}
	}
    
}
//http://www.coderzheaven.com/2011/08/20/how-to-use-radiobuttongroup-in-android/
//http://www.coderzheaven.com/
//http://www.coderzheaven.com/2012/10/20/actionbar-search-option-options-android/
//
//http://www.coderzheaven.com/2012/10/28/pass-arraylist-activity-android/
//http://www.vogella.com/articles/Android/article.html#fragments
//http://www.linuxforu.com/2011/05/android-fragments-api/
//http://www.androidhive.info/2012/05/android-rss-reader-application-using-sqlite-part-2/
//http://www.androidhive.info/2012/05/android-rss-reader-application-using-sqlite-part-2/
//http://lovingandroid.blogspot.com/2012/02/fragments.html
//http://developer.android.com/guide/components/fragments.html
//http://wptrafficanalyzer.in/blog/itemclick-handler-for-listfragment-in-android/
//http://www.heikkitoivonen.net/blog/2009/02/15/multicolumn-listview-in-android/
//http://congeritc.blogspot.com/2012/04/android-passing-values-between-views.html
//http://wptrafficanalyzer.in/blog/dynamically-add-items-to-listview-in-android/
//http://wptrafficanalyzer.in/blog/filterable-listview-in-android/
//http://stackoverflow.com/questions/12872636/different-layouts-for-each-list-item-in-android-fragments
//

//Check Box
//http://developer.android.com/reference/android/widget/CheckBox.html
//Radio Button
//http://matthew-moses.com/main/2011/10/12/getting-selected-radio-button-value-from-radio-group-in-android/
//http://stackoverflow.com/questions/8323778/how-to-set-on-click-listener-on-the-radio-button-in-android
//http://android-er.blogspot.com/2009/11/radiogroup-and-radiobutton.html
//http://wptrafficanalyzer.in/blog/alert-dialog-window-with-radio-buttons-in-android/

//http://developer.android.com/guide/topics/media/camera.html

//http://www.codeproject.com/Articles/439852/Android-with-SQLite-Database-Handling-in-MonoDevel
//http://android-codes-examples.blogspot.com/2011/04/google-map-example-in-android-with-info.html
//http://android-codes-examples.blogspot.com/2011/11/running-service-in-background-on.html
//http://android-codes-examples.blogspot.com/2011/04/animated-customized-popup-transparent.html
//http://android-codes-examples.blogspot.com/2011/03/multiple-listview-and-custom-listview.html
//http://android-codes-examples.blogspot.com/2011/09/image-and-content-is-populated-from.html
//http://androidhub.wordpress.com/2011/08/03/android-intents-for-passing-data-between-activities-part-2/
//http://xjaphx.wordpress.com/2011/07/13/detect-layout-type-landscapeportrait/
//http://www.androidhive.info/2012/05/android-rss-reader-application-using-sqlite-part-2/
//http://neilgoodman.net/2012/03/12/working-with-fragments-on-android-part-2/
//http://neilgoodman.net/2012/03/12/working-with-fragments-on-android-part-2/
//http://lovingandroid.blogspot.com/2012/02/fragments.html
//