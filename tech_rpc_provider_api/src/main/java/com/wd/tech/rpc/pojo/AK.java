package com.wd.tech.rpc.pojo;

/**
 *  ak解析类
 */
public class AK {
	//安卓
	public static final String OS_APPLE = "1";
	//苹果
	public static final String OS_ANDROID = "2";
	
	//影城
	public static final String APP_MOVIE = "001";

	//主版本号
	private int major = -1;
	
	//辅版本号
	private int minor = -1;
	
	//辅版本号2
	private int minor_2 = 0;
	
	//产品
	private String productno;
	
	//操作系统
	private int os = -1;
	
	//渠道号
	private String channelno;
	
	//版本全称
	private String version_name;
	
	//原始ak
	private String ak;
	
	public AK() {
		
	}

	public AK(String ak){
		
		this.ak = ak;
		
		this.parse();
	
	}
	
	/**
	 * ak解析
	 */
	private void parse(){
		try{
			int len = ak.length();
			if(len==13){
				parse_13();
			}else if(len==9){
				parse_9();
			}
			os = Integer.parseInt(ak.substring(2, 3));
			
			productno = ak.substring(3, 6);
			
			channelno = ak.substring(6, 9);
			
			version_name = major + "." + minor + "." + minor_2;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 14位ak解析
	 */
	private void parse_13(){
		major = Integer.parseInt(ak.substring(0, 2));
		
		minor = Integer.parseInt(ak.substring(9, 11));
		
		minor_2 = Integer.parseInt(ak.substring(11, 13));
		
	}

	/**
	 * 9位ak解析
	 */
	private void parse_9(){
		major = Integer.parseInt(ak.substring(0, 1));
		
		minor = Integer.parseInt(ak.substring(1, 2));
		
	}
	
	/**
	 * 当前ak与传入的ak比较
	 * @param ak
	 * @return 返回1表示当前版本高，返回0表示一致 返回-1表示当前版本低
	 */
	public int compare(AK ak){
		return compare(ak.major, ak.minor, ak.minor_2);
	}
	
	public int compare(int major,int minor,int minor_2){
		if(this.major>major) return 1;
		if(this.major<major) return -1;
		if(this.minor>minor) return 1;
		if(this.minor<minor) return -1;
		if(this.minor_2>minor_2) return 1;
		if(this.minor_2<minor_2) return -1;
		return 0;
	}
	
	public int compare(int major,int minor){
		return compare(major,minor,0);
	}
	
	/**
	 * 当前ak与传入的ak字符串比较
	 * @param ak
	 * @return 返回1表示当前版本高，返回0表示一致 返回-1表示当前版本低
	 */
	public int compare(String ak){
		int result = 0;
		try{
			return this.compare(new AK(ak));
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ak与传入的版本号比较
	 * @param ak
	 * @param major
	 * @param minor 两位
	 * @return 返回1表示传入的ak版本高，返回0表示一致 返回-1表示传入的ak版本低
	 */
	public static int compare(String ak, int major, int minor, int minor_2){
		int result = 0;
		try{
			AK ak_obj = new AK(ak);
			return ak_obj.compare(major, minor, minor_2);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * ak与传入的版本号比较
	 * @param ak
	 * @param major
	 * @param minor 两位
	 * @return 返回1表示传入的ak版本高，返回0表示一致 返回-1表示传入的ak版本低
	 */
	public static int compare(String ak, int major, int minor){
		return compare(ak,major,minor,0);
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

	public String getChannelno() {
		return channelno;
	}

	public void setChannelno(String channelno) {
		this.channelno = channelno;
	}

	public String getAk() {
		return ak;
	}

	public void setAk(String ak) {
		this.ak = ak;
	}

	public String getVersion_name() {
		return version_name;
	}

	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}
	
	@Override
	public String toString(){
		return ak;
	}

	public static void main(String [] args)
	{
		AK ak = new AK("0110010010000");
		System.out.println(ak.getVersion_name());
	}
	
	
}
