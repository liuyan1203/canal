//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.AttrDdo.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.lang.GenericWrapper;
import com.paipai.lang.uint32_t;
import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 属性值结构体 
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:0
*/
public class OptionDdo  implements ICanSerializeObjectExt4Encoding
{
	/**
	 *  版本号, version需要小写
	 *
	 * 版本 >= 0
	 */
	 private short version = 146;

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
	 *  类型 
	 *
	 * 版本 >= 0
	 */
	 private long Type;

	/**
	 *  property 
	 *
	 * 版本 >= 0
	 */
	 private long Property;

	/**
	 *  属性值排序 
	 *
	 * 版本 >= 0
	 */
	 private long Order;

	/**
	 * 属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
	 *
	 * 版本 >= 0
	 */
	 private String Name = new String();

	/**
	 *  属性值下的子属性值对 
	 *
	 * 版本 >= 0
	 */
	 private Map<uint32_t,Vector<SubAttrOptionDdo>> SubAttrIds = new HashMap<uint32_t,Vector<SubAttrOptionDdo>>();

	/**
	 * 原始名
	 *
	 * 版本 >= 142
	 */
	 private String NameOriginal = new String();

	/**
	 * 运营加挂时定义的别名
	 *
	 * 版本 >= 142
	 */
	 private String NameOperator = new String();

	/**
	 * 卖家自定义名
	 *
	 * 版本 >= 142
	 */
	 private String NameSeller = new String();

	/**
	 * 对搜索导航有用，属性值备注（文本）
	 *
	 * 版本 >= 143
	 */
	 private String TextComment = new String();

	/**
	 * 对搜索导航有用，属性值备注（图片链接）
	 *
	 * 版本 >= 143
	 */
	 private String PictureComment = new String();

	/**
	 * 对搜索导航有用，属性值备注（知识库链接）
	 *
	 * 版本 >= 143
	 */
	 private String DetailComment = new String();

	/**
	 * 额外数据，key是业务id，value是业务数据
	 *
	 * 版本 >= 144
	 */
	 private Map<uint32_t,String> ExtraData = new HashMap<uint32_t,String>();

	/**
	 * 属性值数值，针对可数值化的属性值有用
	 *
	 * 版本 >= 145
	 */
	 private long Value;

	/**
	 * 属性值拼音
	 *
	 * 版本 >= 145
	 */
	 private String PinYin = new String();

	/**
	 * 全局唯一id
	 *
	 * 版本 >= 146
	 */
	 private long GlobalId;



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUByte(version);
		bs.pushUInt(AttrId);
		bs.pushUInt(OptionId);
		bs.pushUInt(Type);
		bs.pushUInt(Property);
		bs.pushUInt(Order);
		bs.pushString(Name);
		bs.pushObject(SubAttrIds);
		if(  this.version >= 142 ){
				bs.pushString(NameOriginal);
		}
		if(  this.version >= 142 ){
				bs.pushString(NameOperator);
		}
		if(  this.version >= 142 ){
				bs.pushString(NameSeller);
		}
		if(  this.version >= 143 ){
				bs.pushString(TextComment);
		}
		if(  this.version >= 143 ){
				bs.pushString(PictureComment);
		}
		if(  this.version >= 143 ){
				bs.pushString(DetailComment);
		}
		if(  this.version >= 144 ){
				bs.pushObject(ExtraData);
		}
		if(  this.version >= 145 ){
				bs.pushUInt(Value);
		}
		if(  this.version >= 145 ){
				bs.pushString(PinYin);
		}
		if(  this.version >= 146 ){
				bs.pushUInt(GlobalId);
		}
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
		Type = bs.popUInt();
		Property = bs.popUInt();
		Order = bs.popUInt();
		Name = bs.popString();

		// 生成反序列化属性SubAttrIds相应的范型参数包裹对象(包裹了该属性中范型的类型)。 
		GenericWrapper SubAttrIdsPaiPai00 = new GenericWrapper();
		SubAttrIdsPaiPai00.setType(HashMap.class);
		GenericWrapper[] SubAttrIdsPaiPaiArray00= new GenericWrapper[2];
		SubAttrIdsPaiPaiArray00[0] = new GenericWrapper(uint32_t.class);
		SubAttrIdsPaiPaiArray00[1] = new GenericWrapper();
		GenericWrapper SubAttrIdsPaiPai11 = new GenericWrapper();
		SubAttrIdsPaiPai11.setType(Vector.class);
		GenericWrapper[] SubAttrIdsPaiPaiArray11= new GenericWrapper[2];
		SubAttrIdsPaiPaiArray11[0] = new GenericWrapper(SubAttrOptionDdo.class);
		SubAttrIdsPaiPai11.setGenericParameters(SubAttrIdsPaiPaiArray11);


		SubAttrIdsPaiPaiArray00[1] = SubAttrIdsPaiPai11;
		SubAttrIdsPaiPai00.setGenericParameters(SubAttrIdsPaiPaiArray00);



		SubAttrIds = (Map<uint32_t,Vector<SubAttrOptionDdo>>)bs.popObject(SubAttrIdsPaiPai00);
		if(  version >= 142 ){
				NameOriginal = bs.popString();
		}
		if(  version >= 142 ){
				NameOperator = bs.popString();
		}
		if(  version >= 142 ){
				NameSeller = bs.popString();
		}
		if(  version >= 143 ){
				TextComment = bs.popString();
		}
		if(  version >= 143 ){
				PictureComment = bs.popString();
		}
		if(  version >= 143 ){
				DetailComment = bs.popString();
		}
		if(  version >= 144 ){
				ExtraData = (Map<uint32_t,String>)bs.popMap(uint32_t.class,String.class);
		}
		if(  version >= 145 ){
				Value = bs.popUInt();
		}
		if(  version >= 145 ){
				PinYin = bs.popString();
		}
		if(  version >= 146 ){
				GlobalId = bs.popUInt();
		}

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
	 * 获取 类型 
	 * 
	 * 此字段的版本 >= 0
	 * @return Type value 类型为:long
	 * 
	 */
	public long getType()
	{
		return Type;
	}


	/**
	 * 设置 类型 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setType(long value)
	{
		this.Type = value;
	}


	/**
	 * 获取 property 
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
	 * 设置 property 
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
	 * 获取 属性值排序 
	 * 
	 * 此字段的版本 >= 0
	 * @return Order value 类型为:long
	 * 
	 */
	public long getOrder()
	{
		return Order;
	}


	/**
	 * 设置 属性值排序 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setOrder(long value)
	{
		this.Order = value;
	}


	/**
	 * 获取属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
	 * 
	 * 此字段的版本 >= 0
	 * @return Name value 类型为:String
	 * 
	 */
	public String getName()
	{
		return Name;
	}


	/**
	 * 设置属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setName(String value)
	{
		this.Name = value;
	}


	/**
	 * 获取 属性值下的子属性值对 
	 * 
	 * 此字段的版本 >= 0
	 * @return SubAttrIds value 类型为:Map<uint32_t,Vector<SubAttrOptionDdo>>
	 * 
	 */
	public Map<uint32_t,Vector<SubAttrOptionDdo>> getSubAttrIds()
	{
		return SubAttrIds;
	}


	/**
	 * 设置 属性值下的子属性值对 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Map<uint32_t,Vector<SubAttrOptionDdo>>
	 * 
	 */
	public void setSubAttrIds(Map<uint32_t,Vector<SubAttrOptionDdo>> value)
	{
		if (value != null) {
				this.SubAttrIds = value;
		}else{
				this.SubAttrIds = new HashMap<uint32_t,Vector<SubAttrOptionDdo>>();
		}
	}


	/**
	 * 获取原始名
	 * 
	 * 此字段的版本 >= 142
	 * @return NameOriginal value 类型为:String
	 * 
	 */
	public String getNameOriginal()
	{
		return NameOriginal;
	}


	/**
	 * 设置原始名
	 * 
	 * 此字段的版本 >= 142
	 * @param  value 类型为:String
	 * 
	 */
	public void setNameOriginal(String value)
	{
		this.NameOriginal = value;
	}


	/**
	 * 获取运营加挂时定义的别名
	 * 
	 * 此字段的版本 >= 142
	 * @return NameOperator value 类型为:String
	 * 
	 */
	public String getNameOperator()
	{
		return NameOperator;
	}


	/**
	 * 设置运营加挂时定义的别名
	 * 
	 * 此字段的版本 >= 142
	 * @param  value 类型为:String
	 * 
	 */
	public void setNameOperator(String value)
	{
		this.NameOperator = value;
	}


	/**
	 * 获取卖家自定义名
	 * 
	 * 此字段的版本 >= 142
	 * @return NameSeller value 类型为:String
	 * 
	 */
	public String getNameSeller()
	{
		return NameSeller;
	}


	/**
	 * 设置卖家自定义名
	 * 
	 * 此字段的版本 >= 142
	 * @param  value 类型为:String
	 * 
	 */
	public void setNameSeller(String value)
	{
		this.NameSeller = value;
	}


	/**
	 * 获取对搜索导航有用，属性值备注（文本）
	 * 
	 * 此字段的版本 >= 143
	 * @return TextComment value 类型为:String
	 * 
	 */
	public String getTextComment()
	{
		return TextComment;
	}


	/**
	 * 设置对搜索导航有用，属性值备注（文本）
	 * 
	 * 此字段的版本 >= 143
	 * @param  value 类型为:String
	 * 
	 */
	public void setTextComment(String value)
	{
		this.TextComment = value;
	}


	/**
	 * 获取对搜索导航有用，属性值备注（图片链接）
	 * 
	 * 此字段的版本 >= 143
	 * @return PictureComment value 类型为:String
	 * 
	 */
	public String getPictureComment()
	{
		return PictureComment;
	}


	/**
	 * 设置对搜索导航有用，属性值备注（图片链接）
	 * 
	 * 此字段的版本 >= 143
	 * @param  value 类型为:String
	 * 
	 */
	public void setPictureComment(String value)
	{
		this.PictureComment = value;
	}


	/**
	 * 获取对搜索导航有用，属性值备注（知识库链接）
	 * 
	 * 此字段的版本 >= 143
	 * @return DetailComment value 类型为:String
	 * 
	 */
	public String getDetailComment()
	{
		return DetailComment;
	}


	/**
	 * 设置对搜索导航有用，属性值备注（知识库链接）
	 * 
	 * 此字段的版本 >= 143
	 * @param  value 类型为:String
	 * 
	 */
	public void setDetailComment(String value)
	{
		this.DetailComment = value;
	}


	/**
	 * 获取额外数据，key是业务id，value是业务数据
	 * 
	 * 此字段的版本 >= 144
	 * @return ExtraData value 类型为:Map<uint32_t,String>
	 * 
	 */
	public Map<uint32_t,String> getExtraData()
	{
		return ExtraData;
	}


	/**
	 * 设置额外数据，key是业务id，value是业务数据
	 * 
	 * 此字段的版本 >= 144
	 * @param  value 类型为:Map<uint32_t,String>
	 * 
	 */
	public void setExtraData(Map<uint32_t,String> value)
	{
		if (value != null) {
				this.ExtraData = value;
		}else{
				this.ExtraData = new HashMap<uint32_t,String>();
		}
	}


	/**
	 * 获取属性值数值，针对可数值化的属性值有用
	 * 
	 * 此字段的版本 >= 145
	 * @return Value value 类型为:long
	 * 
	 */
	public long getValue()
	{
		return Value;
	}


	/**
	 * 设置属性值数值，针对可数值化的属性值有用
	 * 
	 * 此字段的版本 >= 145
	 * @param  value 类型为:long
	 * 
	 */
	public void setValue(long value)
	{
		this.Value = value;
	}


	/**
	 * 获取属性值拼音
	 * 
	 * 此字段的版本 >= 145
	 * @return PinYin value 类型为:String
	 * 
	 */
	public String getPinYin()
	{
		return PinYin;
	}


	/**
	 * 设置属性值拼音
	 * 
	 * 此字段的版本 >= 145
	 * @param  value 类型为:String
	 * 
	 */
	public void setPinYin(String value)
	{
		this.PinYin = value;
	}


	/**
	 * 获取全局唯一id
	 * 
	 * 此字段的版本 >= 146
	 * @return GlobalId value 类型为:long
	 * 
	 */
	public long getGlobalId()
	{
		return GlobalId;
	}


	/**
	 * 设置全局唯一id
	 * 
	 * 此字段的版本 >= 146
	 * @param  value 类型为:long
	 * 
	 */
	public void setGlobalId(long value)
	{
		this.GlobalId = value;
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
				length = 4;  //size_of(OptionDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段AttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段OptionId的长度 size_of(uint32_t)
				length += 4;  //计算字段Type的长度 size_of(uint32_t)
				length += 4;  //计算字段Property的长度 size_of(uint32_t)
				length += 4;  //计算字段Order的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Name, null);  //计算字段Name的长度 size_of(String)
				length += ByteStream.getObjectSize(SubAttrIds, null);  //计算字段SubAttrIds的长度 size_of(Map)
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(NameOriginal, null);  //计算字段NameOriginal的长度 size_of(String)
				}
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(NameOperator, null);  //计算字段NameOperator的长度 size_of(String)
				}
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(NameSeller, null);  //计算字段NameSeller的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(TextComment, null);  //计算字段TextComment的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(PictureComment, null);  //计算字段PictureComment的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(DetailComment, null);  //计算字段DetailComment的长度 size_of(String)
				}
				if(  this.version >= 144 ){
						length += ByteStream.getObjectSize(ExtraData, null);  //计算字段ExtraData的长度 size_of(Map)
				}
				if(  this.version >= 145 ){
						length += 4;  //计算字段Value的长度 size_of(uint32_t)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(PinYin, null);  //计算字段PinYin的长度 size_of(String)
				}
				if(  this.version >= 146 ){
						length += 4;  //计算字段GlobalId的长度 size_of(uint32_t)
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
				length = 4;  //size_of(OptionDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段AttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段OptionId的长度 size_of(uint32_t)
				length += 4;  //计算字段Type的长度 size_of(uint32_t)
				length += 4;  //计算字段Property的长度 size_of(uint32_t)
				length += 4;  //计算字段Order的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Name, encoding);  //计算字段Name的长度 size_of(String)
				length += ByteStream.getObjectSize(SubAttrIds, encoding);  //计算字段SubAttrIds的长度 size_of(Map)
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(NameOriginal, encoding);  //计算字段NameOriginal的长度 size_of(String)
				}
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(NameOperator, encoding);  //计算字段NameOperator的长度 size_of(String)
				}
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(NameSeller, encoding);  //计算字段NameSeller的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(TextComment, encoding);  //计算字段TextComment的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(PictureComment, encoding);  //计算字段PictureComment的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(DetailComment, encoding);  //计算字段DetailComment的长度 size_of(String)
				}
				if(  this.version >= 144 ){
						length += ByteStream.getObjectSize(ExtraData, encoding);  //计算字段ExtraData的长度 size_of(Map)
				}
				if(  this.version >= 145 ){
						length += 4;  //计算字段Value的长度 size_of(uint32_t)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(PinYin, encoding);  //计算字段PinYin的长度 size_of(String)
				}
				if(  this.version >= 146 ){
						length += 4;  //计算字段GlobalId的长度 size_of(uint32_t)
				}
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


/**
 ********************以下信息是每个版本的字段********************
 *
 *****以下是版本144所包含的字段*******
 *	short version;///< 版本号, version需要小写
 *	long AttrId;///< 属性项id 
 *	long OptionId;///< 属性值id 
 *	long Type;///< 类型 
 *	long Property;///< property 
 *	long Order;///< 属性值排序 
 *	String Name;///<属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	Map<uint32_t,Vector<SubAttrOptionDdo>> SubAttrIds;///< 属性值下的子属性值对 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	String TextComment;///<对搜索导航有用，属性值备注（文本）
 *	String PictureComment;///<对搜索导航有用，属性值备注（图片链接）
 *	String DetailComment;///<对搜索导航有用，属性值备注（知识库链接）
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *****以上是版本144所包含的字段*******
 *
 *****以下是版本145所包含的字段*******
 *	short version;///< 版本号, version需要小写
 *	long AttrId;///< 属性项id 
 *	long OptionId;///< 属性值id 
 *	long Type;///< 类型 
 *	long Property;///< property 
 *	long Order;///< 属性值排序 
 *	String Name;///<属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	Map<uint32_t,Vector<SubAttrOptionDdo>> SubAttrIds;///< 属性值下的子属性值对 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	String TextComment;///<对搜索导航有用，属性值备注（文本）
 *	String PictureComment;///<对搜索导航有用，属性值备注（图片链接）
 *	String DetailComment;///<对搜索导航有用，属性值备注（知识库链接）
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	long Value;///<属性值数值，针对可数值化的属性值有用
 *	String PinYin;///<属性值拼音
 *****以上是版本145所包含的字段*******
 *
 *****以下是版本146所包含的字段*******
 *	short version;///< 版本号, version需要小写
 *	long AttrId;///< 属性项id 
 *	long OptionId;///< 属性值id 
 *	long Type;///< 类型 
 *	long Property;///< property 
 *	long Order;///< 属性值排序 
 *	String Name;///<属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	Map<uint32_t,Vector<SubAttrOptionDdo>> SubAttrIds;///< 属性值下的子属性值对 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	String TextComment;///<对搜索导航有用，属性值备注（文本）
 *	String PictureComment;///<对搜索导航有用，属性值备注（图片链接）
 *	String DetailComment;///<对搜索导航有用，属性值备注（知识库链接）
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	long Value;///<属性值数值，针对可数值化的属性值有用
 *	String PinYin;///<属性值拼音
 *	long GlobalId;///<全局唯一id
 *****以上是版本146所包含的字段*******
 *
 *****以下是版本142所包含的字段*******
 *	short version;///< 版本号, version需要小写
 *	long AttrId;///< 属性项id 
 *	long OptionId;///< 属性值id 
 *	long Type;///< 类型 
 *	long Property;///< property 
 *	long Order;///< 属性值排序 
 *	String Name;///<属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	Map<uint32_t,Vector<SubAttrOptionDdo>> SubAttrIds;///< 属性值下的子属性值对 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *****以上是版本142所包含的字段*******
 *
 *****以下是版本143所包含的字段*******
 *	short version;///< 版本号, version需要小写
 *	long AttrId;///< 属性项id 
 *	long OptionId;///< 属性值id 
 *	long Type;///< 类型 
 *	long Property;///< property 
 *	long Order;///< 属性值排序 
 *	String Name;///<属性值名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	Map<uint32_t,Vector<SubAttrOptionDdo>> SubAttrIds;///< 属性值下的子属性值对 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	String TextComment;///<对搜索导航有用，属性值备注（文本）
 *	String PictureComment;///<对搜索导航有用，属性值备注（图片链接）
 *	String DetailComment;///<对搜索导航有用，属性值备注（知识库链接）
 *****以上是版本143所包含的字段*******
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
