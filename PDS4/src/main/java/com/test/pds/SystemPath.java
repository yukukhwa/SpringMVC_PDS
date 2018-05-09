package com.test.pds;

import java.io.File;

public class SystemPath {
	/*
	 * cafe24 호스팅 서비스 이용시 /home/hosting_users/(자신의 id)폴더를 제공받는다
	 * 파일은 /home/hosting_users/(자신의 id)/tomcat/webapps/ROOT/resources/upload내에
	 * 저장하기로 했으므로 절대경로를 찾아준다
	 */
	private static File file = new File("tomcat/webapps/ROOT/resources/upload");
	// 유국화
	public static final String DOWNLOAD_PATH_1 = file.getAbsolutePath();
	// 나성수
	public static final String DOWNLOAD_PATH_2 = file.getAbsolutePath();
	// 김재희
	public static final String DOWNLOAD_PATH_3 = file.getAbsolutePath();
	// 배건혜
	public static final String DOWNLOAD_PATH_4 = file.getAbsolutePath();
}
