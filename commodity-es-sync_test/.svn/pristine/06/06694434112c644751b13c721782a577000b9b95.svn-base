//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.OptionDdo.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

/**
 * 属性值下子属性值对结构体 
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:0
*/
public class SubAttrOptionDdo  implements ICanSerializeObjectExt4Encoding
{
	/**
	 *  版本号, version需要小写 
	 *
	 * 版本 >= 0
	 */
	 private short version;

	/**
	 *  属性项id 
	 *
	 * 版本 >= 0
	 */
	 private long AttrId;

	/**
	 *  属性值id 
	 *
	 * 版本 >= 0
	 */
	 private long OptionId;

	/**
	 *  值对property 
	 *
	 * 版本 >= 0
	 */
	 private long Property;



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUByte(version);
		bs.pushUInt(AttrId);
		bs.pushUInt(OptionId);
		bs.pushUInt(Property);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		long size = bs.popUInt();
		int startPosPop = bs.getReadLength();
		if (size == 0)
				return 0;
		version = bs.popUByte();
		AttrId = bs.popUInt();
		OptionId = bs.popUInt();
		Property = bs.popUInt();

		/**********************为了支持多个版本的客户端************************/
		int needPopBytes = (int)size - (bs.getReadLength() - startPosPop);
		for(int i = 0;i< needPopBytes; i++)
				bs.popByte();
		/**********************为了支持多个版本的客户端************************/

		return bs.getReadLength();
	} 


	/**
	 * 获取 版本号, version需要小写 
	 * 
	 * 此字段的版本 >= 0
	 * @return version value 类型为:short
	 * 
	 */
	public short getVersion()
	{
		return version;
	}


	/**
	 * 设置 版本号, version需要小写 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	private void setVersion(short value)
	{
		this.version = value;
	}


	/**
	 * 获取 属性项id 
	 * 
	 * 此字段的版本 >= 0
	 * @return AttrId value 类型为:long
	 * 
	 */
	public long getAttrId()
	{
		return AttrId;
	}


	/**
	 * 设置 属性项id 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setAttrId(long value)
	{
		this.AttrId = value;
	}


	/**
	 * 获取 属性值id 
	 * 
	 * 此字段的版本 >= 0
	 * @return OptionId value 类型为:long
	 * 
	 */
	public long getOptionId()
	{
		return OptionId;
	}


	/**
	 * 设置 属性值id 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setOptionId(long value)
	{
		this.OptionId = value;
	}


	/**
	 * 获取 值对property 
	 * 
	 * 此字段的版本 >= 0
	 * @return Property value 类型为:long
	 * 
	 */
	public long getProperty()
	{
		return Property;
	}


	/**
	 * 设置 值对property 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setProperty(long value)
	{
		this.Property = value;
	}


	/**
	 *   计算类长度
	 *   用于告诉解包者，该类只放了这么长的数据
	 *  
 	 */
	protected int getClassSize()
	{
		int length = getSize() - 4;
		try{

		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}

	
	/**
	 *   计算类长度
	 *   这个是该类的实际长度，在序列化时bytestream会调用这个方法
	 *  
 	 */
	public int getSize()
	{
		int length = 4;
		try{
				length = 4;  //size_of(SubAttrOptionDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段AttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段OptionId的长度 size_of(uint32_t)
				length += 4;  //计算字段Property的长度 size_of(uint32_t)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


	/**
	 *   计算类长度
	 *   这个是实现String字符集传入的方法
	 *  
 	 */
	public int getSize(String encoding)
	{
		int length = 4;
		try{
				length = 4;  //size_of(SubAttrOptionDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段AttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段OptionId的长度 size_of(uint32_t)
				length += 4;  //计算字段Property的长度 size_of(uint32_t)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


/**
 ********************以下信息是每个版本的字段********************
 */



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
