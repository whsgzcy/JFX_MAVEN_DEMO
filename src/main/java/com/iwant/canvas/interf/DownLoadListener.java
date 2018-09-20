package com.iwant.canvas.interf;

public interface DownLoadListener {

	void onStart();

	void onProgress(int currentLength);

	void onFinish(String localPath);

	void onFailure();

}