package com.iwant.canvas.interf;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface Service {

	/**
	 * 下载视频
	 * 大文件时要加不然会OOM
	 * @param fileUrl
	 * @return
	 */
	@Streaming
	@GET
	Call<ResponseBody> downloadFile(@Url String fileUrl);

}
