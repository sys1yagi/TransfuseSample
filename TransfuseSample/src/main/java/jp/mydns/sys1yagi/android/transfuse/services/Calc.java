package jp.mydns.sys1yagi.android.transfuse.services;

import org.androidtransfuse.annotations.Intent;
import org.androidtransfuse.annotations.IntentFilter;
import org.androidtransfuse.annotations.IntentType;
import org.androidtransfuse.annotations.Service;

@Service
@IntentFilter(@Intent(type= IntentType.ACTION, name="transfuse"))
public class Calc {


}
