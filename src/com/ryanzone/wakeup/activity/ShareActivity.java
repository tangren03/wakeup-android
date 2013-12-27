package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;
import com.ryanzone.wakeup.utils.Common;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
/**
 * 
 * ShareActivity.java
 * @author Ryan
 * Create at 2013-12-26 下午9:17:44
 */
public class ShareActivity extends RTActivity implements OnClickListener{

	private IWXAPI wxApi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//register wechat id
		wxApi = WXAPIFactory.createWXAPI(this, Common.WX_APP_ID, true);
		wxApi.registerApp(Common.WX_APP_ID);
	}
	
	@Override
	public void init() {
		this.findViewById(R.id.btn_step).setOnClickListener(this);
		this.findViewById(R.id.btn_challenge).setOnClickListener(this);
		this.findViewById(R.id.btn_share).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int viewID = v.getId();
		switch (viewID) {
		case R.id.btn_challenge://challenge friends
			
			break;
		case R.id.btn_share://share to wechat timeline
			WXTextObject textObj = new WXTextObject();
			textObj.text = "android test demo";

			WXMediaMessage msg = new WXMediaMessage();
			msg.mediaObject = textObj;
			msg.title = "Will be ignored";
			msg.description = "description";

			SendMessageToWX.Req req = new SendMessageToWX.Req();
			req.transaction = buildTransaction("text"); 
			req.message = msg;
			req.scene = Req.WXSceneTimeline;
			wxApi.sendReq(req);
			
			break;
		case R.id.btn_step:
			//close current page
			finish();
			break;

		default:
			break;
		}
	}

	private String buildTransaction(final String type) {
		return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
	}
	
	@Override
	public void loadViewLayout() {
		setContentView(R.layout.activity_share);
	}
}
