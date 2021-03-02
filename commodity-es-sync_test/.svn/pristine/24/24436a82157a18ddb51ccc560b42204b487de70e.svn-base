 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

import java.util.Vector;

/**
 * 根据导航ID获取相应路径响应 
 *
 *@date 2020-06-20 06:26:26
 *
 *@since version:0
*/
public class  GetPathByNavId_WGResp extends NetMessage
{
	/**
	 * 错误信息
	 *
	 * 版本 >= 0
	 */
	 private String errmsg = new String();

	/**
	 * 导航路径
	 *
	 * 版本 >= 0
	 */
	 private Vector<NavEntryDdo> fullPath = new Vector<NavEntryDdo>();

	/**
	 * 子节点集合
	 *
	 * 版本 >= 0
	 */
	 private Vector<NavEntryDdo> childNav = new Vector<NavEntryDdo>();

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
		bs.pushObject(fullPath);
		bs.pushObject(childNav);
		bs.pushString(outReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{

		result = bs.popUInt();
		errmsg = bs.popString();
		fullPath = (Vector<NavEntryDdo>)bs.popVector(NavEntryDdo.class);
		childNav = (Vector<NavEntryDdo>)bs.popVector(NavEntryDdo.class);
		outReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA001880fL;
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
	 * 获取导航路径
	 * 
	 * 此字段的版本 >= 0
	 * @return fullPath value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public Vector<NavEntryDdo> getFullPath()
	{
		return fullPath;
	}


	/**
	 * 设置导航路径
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public void setFullPath(Vector<NavEntryDdo> value)
	{
		if (value != null) {
				this.fullPath = value;
		}else{
				this.fullPath = new Vector<NavEntryDdo>();
		}
	}


	/**
	 * 获取子节点集合
	 * 
	 * 此字段的版本 >= 0
	 * @return childNav value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public Vector<NavEntryDdo> getChildNav()
	{
		return childNav;
	}


	/**
	 * 设置子节点集合
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public void setChildNav(Vector<NavEntryDdo> value)
	{
		if (value != null) {
				this.childNav = value;
		}else{
				this.childNav = new Vector<NavEntryDdo>();
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
				length = 4;  //size_of(GetPathByNavId_WGResp)
				length += ByteStream.getObjectSize(errmsg, null);  //计算字段errmsg的长度 size_of(String)
				length += ByteStream.getObjectSize(fullPath, null);  //计算字段fullPath的长度 size_of(Vector)
				length += ByteStream.getObjectSize(childNav, null);  //计算字段childNav的长度 size_of(Vector)
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
				length = 0;  //size_of(GetPathByNavId_WGResp)
				length += ByteStream.getObjectSize(errmsg, encoding);  //计算字段errmsg的长度 size_of(String)
				length += ByteStream.getObjectSize(fullPath, encoding);  //计算字段fullPath的长度 size_of(Vector)
				length += ByteStream.getObjectSize(childNav, encoding);  //计算字段childNav的长度 size_of(Vector)
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
