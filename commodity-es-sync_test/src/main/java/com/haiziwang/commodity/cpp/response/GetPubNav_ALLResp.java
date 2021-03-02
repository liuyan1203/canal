 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

/**
 *
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:1
*/
public class  GetPubNav_ALLResp extends NetMessage
{
	/**
	 * 错误信息
	 *
	 * 版本 >= 0
	 */
	 private String errmsg = new String();

	/**
	 * 品类数据
	 *
	 * 版本 >= 0
	 */
	 private NavExDdo Nav = new NavExDdo();

	/**
	 * 输出保留字
	 *
	 * 版本 >= 0
	 */
	 private String outReserve = new String();


	public int serialize(ByteStream bs) throws Exception
	{

		bs.pushUInt(result);
		bs.pushString(errmsg);
		bs.pushObject(Nav);
		bs.pushString(outReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{

		result = bs.popUInt();
		errmsg = bs.popString();
		Nav = (NavExDdo) bs.popObject(NavExDdo.class);
		outReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA0018822L;
	}


	/**
	 * 获取错误信息
	 * 
	 * 此字段的版本 >= 0
	 * @return errmsg value 类型为:String
	 * 
	 */
	public String getErrmsg()
	{
		return errmsg;
	}


	/**
	 * 设置错误信息
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setErrmsg(String value)
	{
		this.errmsg = value;
	}


	/**
	 * 获取品类数据
	 * 
	 * 此字段的版本 >= 0
	 * @return Nav value 类型为:NavExDdo
	 * 
	 */
	public NavExDdo getNav()
	{
		return Nav;
	}


	/**
	 * 设置品类数据
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:NavExDdo
	 * 
	 */
	public void setNav(NavExDdo value)
	{
		if (value != null) {
				this.Nav = value;
		}else{
				this.Nav = new NavExDdo();
		}
	}


	/**
	 * 获取输出保留字
	 * 
	 * 此字段的版本 >= 0
	 * @return outReserve value 类型为:String
	 * 
	 */
	public String getOutReserve()
	{
		return outReserve;
	}


	/**
	 * 设置输出保留字
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setOutReserve(String value)
	{
		this.outReserve = value;
	}


	protected int getClassSize()
	{
		return  getSize() - 4;
	}

	
	public int getSize()
	{
		int length = 4;
		try{
				length = 4;  //size_of(GetPubNav_ALLResp)
				length += ByteStream.getObjectSize(errmsg, null);  //计算字段errmsg的长度 size_of(String)
				length += ByteStream.getObjectSize(Nav, null);  //计算字段Nav的长度 size_of(NavExDdo)
				length += ByteStream.getObjectSize(outReserve, null);  //计算字段outReserve的长度 size_of(String)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}
	public int getSize(String encoding)
	{
		int length = 0;
		try{
				length = 0;  //size_of(GetPubNav_ALLResp)
				length += ByteStream.getObjectSize(errmsg, encoding);  //计算字段errmsg的长度 size_of(String)
				length += ByteStream.getObjectSize(Nav, encoding);  //计算字段Nav的长度 size_of(NavExDdo)
				length += ByteStream.getObjectSize(outReserve, encoding);  //计算字段outReserve的长度 size_of(String)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}

	/**
	 *下面是生成toString()方法
	 此方法用于调试时打开*
	 *如果要打开此方法，请加入commons-lang-2.4.jar
	 *并导入 import org.apache.commons.lang.builder.ToStringBuilder;
	 *      import org.apache.commons.lang.builder.ToStringStyle;
	 *
	 */
	//@Override
	//public String toString() {
	//	return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	//}
}
