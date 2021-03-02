//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.request;


import com.paipai.lang.uint32_t;
import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.HashSet;
import java.util.Set;

/**
 *接口调用控制
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:0
*/
public class APIControl implements ICanSerializeObjectExt4Encoding
{
	/**
	 * 版本号, version需要小写
	 *
	 * 版本 >= 0
	 */
	 private long version = 2;

	/**
	 * 入参编码类型。1:GBK; 2:UTF-8; 0:非法，即使入参中没有字符串类型的数据，也必须填一个(填1或者2都行)
	 *
	 * 版本 >= 0
	 */
	 private long Charset;

	/**
	 * 来源，1:易讯，2:拍拍
	 *
	 * 版本 >= 0
	 */
	 private long Source;

	/**
	 * 跟Source和具体接口有关的选项，具体看各个接口对于APIControl参数的说明（如果有的话）
	 *
	 * 版本 >= 0
	 */
	 private long Option;

	/**
	 * 回参编码类型，0:与Charset相同，1:GBK，2:UTF-8
	 *
	 * 版本 >= 1
	 */
	 private long CharsetRsp;

	/**
	 * 额外数据的业务id
	 *
	 * 版本 >= 2
	 */
	 private Set<uint32_t> ExtraId = new HashSet<uint32_t>();



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUInt(version);
		bs.pushUInt(Charset);
		bs.pushUInt(Source);
		bs.pushUInt(Option);
		if(  this.version >= 1 ){
				bs.pushUInt(CharsetRsp);
		}
		if(  this.version >= 2 ){
				bs.pushObject(ExtraId);
		}
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		long size = bs.popUInt();
		int startPosPop = bs.getReadLength();
		if (size == 0)
				return 0;
		version = bs.popUInt();
		Charset = bs.popUInt();
		Source = bs.popUInt();
		Option = bs.popUInt();
		if(  version >= 1 ){
				CharsetRsp = bs.popUInt();
		}
		if(  version >= 2 ){
				ExtraId = (Set<uint32_t>)bs.popSet(HashSet.class, uint32_t.class);
		}

		/**********************为了支持多个版本的客户端************************/
		int needPopBytes = (int)size - (bs.getReadLength() - startPosPop);
		for(int i = 0;i< needPopBytes; i++)
				bs.popByte();
		/**********************为了支持多个版本的客户端************************/

		return bs.getReadLength();
	} 


	/**
	 * 获取版本号, version需要小写
	 * 
	 * 此字段的版本 >= 0
	 * @return version value 类型为:long
	 * 
	 */
	public long getVersion()
	{
		return version;
	}


	/**
	 * 设置版本号, version需要小写
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	private void setVersion(long value)
	{
		this.version = value;
	}


	/**
	 * 获取入参编码类型。1:GBK; 2:UTF-8; 0:非法，即使入参中没有字符串类型的数据，也必须填一个(填1或者2都行)
	 * 
	 * 此字段的版本 >= 0
	 * @return Charset value 类型为:long
	 * 
	 */
	public long getCharset()
	{
		return Charset;
	}


	/**
	 * 设置入参编码类型。1:GBK; 2:UTF-8; 0:非法，即使入参中没有字符串类型的数据，也必须填一个(填1或者2都行)
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setCharset(long value)
	{
		this.Charset = value;
	}


	/**
	 * 获取来源，1:易讯，2:拍拍
	 * 
	 * 此字段的版本 >= 0
	 * @return Source value 类型为:long
	 * 
	 */
	public long getSource()
	{
		return Source;
	}


	/**
	 * 设置来源，1:易讯，2:拍拍
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setSource(long value)
	{
		this.Source = value;
	}


	/**
	 * 获取跟Source和具体接口有关的选项，具体看各个接口对于APIControl参数的说明（如果有的话）
	 * 
	 * 此字段的版本 >= 0
	 * @return Option value 类型为:long
	 * 
	 */
	public long getOption()
	{
		return Option;
	}


	/**
	 * 设置跟Source和具体接口有关的选项，具体看各个接口对于APIControl参数的说明（如果有的话）
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setOption(long value)
	{
		this.Option = value;
	}


	/**
	 * 获取回参编码类型，0:与Charset相同，1:GBK，2:UTF-8
	 * 
	 * 此字段的版本 >= 1
	 * @return CharsetRsp value 类型为:long
	 * 
	 */
	public long getCharsetRsp()
	{
		return CharsetRsp;
	}


	/**
	 * 设置回参编码类型，0:与Charset相同，1:GBK，2:UTF-8
	 * 
	 * 此字段的版本 >= 1
	 * @param  value 类型为:long
	 * 
	 */
	public void setCharsetRsp(long value)
	{
		this.CharsetRsp = value;
	}


	/**
	 * 获取额外数据的业务id
	 * 
	 * 此字段的版本 >= 2
	 * @return ExtraId value 类型为:Set<uint32_t>
	 * 
	 */
	public Set<uint32_t> getExtraId()
	{
		return ExtraId;
	}


	/**
	 * 设置额外数据的业务id
	 * 
	 * 此字段的版本 >= 2
	 * @param  value 类型为:Set<uint32_t>
	 * 
	 */
	public void setExtraId(Set<uint32_t> value)
	{
		if (value != null) {
				this.ExtraId = value;
		}else{
				this.ExtraId = new HashSet<uint32_t>();
		}
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
				length = 4;  //size_of(APIControl)
				length += 4;  //计算字段version的长度 size_of(uint32_t)
				length += 4;  //计算字段Charset的长度 size_of(uint32_t)
				length += 4;  //计算字段Source的长度 size_of(uint32_t)
				length += 4;  //计算字段Option的长度 size_of(uint32_t)
				if(  this.version >= 1 ){
						length += 4;  //计算字段CharsetRsp的长度 size_of(uint32_t)
				}
				if(  this.version >= 2 ){
						length += ByteStream.getObjectSize(ExtraId, null);  //计算字段ExtraId的长度 size_of(Set)
				}
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
				length = 4;  //size_of(APIControl)
				length += 4;  //计算字段version的长度 size_of(uint32_t)
				length += 4;  //计算字段Charset的长度 size_of(uint32_t)
				length += 4;  //计算字段Source的长度 size_of(uint32_t)
				length += 4;  //计算字段Option的长度 size_of(uint32_t)
				if(  this.version >= 1 ){
						length += 4;  //计算字段CharsetRsp的长度 size_of(uint32_t)
				}
				if(  this.version >= 2 ){
						length += ByteStream.getObjectSize(ExtraId, encoding);  //计算字段ExtraId的长度 size_of(Set)
				}
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


/**
 ********************以下信息是每个版本的字段********************
 *
 *****以下是版本1所包含的字段*******
 *	long version;///<版本号, version需要小写
 *	long Charset;///<入参编码类型。1:GBK; 2:UTF-8; 0:非法，即使入参中没有字符串类型的数据，也必须填一个(填1或者2都行)
 *	long Source;///<来源，1:易讯，2:拍拍
 *	long Option;///<跟Source和具体接口有关的选项，具体看各个接口对于APIControl参数的说明（如果有的话）
 *	long CharsetRsp;///<回参编码类型，0:与Charset相同，1:GBK，2:UTF-8
 *****以上是版本1所包含的字段*******
 *
 *****以下是版本2所包含的字段*******
 *	long version;///<版本号, version需要小写
 *	long Charset;///<入参编码类型。1:GBK; 2:UTF-8; 0:非法，即使入参中没有字符串类型的数据，也必须填一个(填1或者2都行)
 *	long Source;///<来源，1:易讯，2:拍拍
 *	long Option;///<跟Source和具体接口有关的选项，具体看各个接口对于APIControl参数的说明（如果有的话）
 *	long CharsetRsp;///<回参编码类型，0:与Charset相同，1:GBK，2:UTF-8
 *	Set<uint32_t> ExtraId;///<额外数据的业务id
 *****以上是版本2所包含的字段*******
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
