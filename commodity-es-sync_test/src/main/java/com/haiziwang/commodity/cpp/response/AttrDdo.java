//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.lang.uint32_t;
import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 导航属性项结构体 
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:0
*/
public class AttrDdo implements ICanSerializeObjectExt4Encoding
{
	/**
	 *  版本号, version需要小写 
	 *
	 * 版本 >= 0
	 */
	 private short version = 147;

	/**
	 *  属性项id 
	 *
	 * 版本 >= 0
	 */
	 private long AttrId;

	/**
	 * 导航id
	 *
	 * 版本 >= 0
	 */
	 private long NavId;

	/**
	 * 属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
	 *
	 * 版本 >= 0
	 */
	 private String Name = new String();

	/**
	 *  property 
	 *
	 * 版本 >= 0
	 */
	 private long Property;

	/**
	 *  类型 
	 *
	 * 版本 >= 0
	 */
	 private long Type;

	/**
	 * 父属性项id
	 *
	 * 版本 >= 0
	 */
	 private long PAttrId;

	/**
	 * 父属性值id
	 *
	 * 版本 >= 0
	 */
	 private long POptionId;

	/**
	 *  属性项描述 
	 *
	 * 版本 >= 0
	 */
	 private String Desc = new String();

	/**
	 *  属性项排序 
	 *
	 * 版本 >= 0
	 */
	 private long Order;

	/**
	 *  属性值集合 
	 *
	 * 版本 >= 0
	 */
	 private Vector<OptionDdo> Options = new Vector<OptionDdo>();

	/**
	 *  是否选项，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsOptional;

	/**
	 *  是否文本，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsText;

	/**
	 *  是否单选，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsSingle;

	/**
	 *  是否多选，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsMulti;

	/**
	 *  是否可选，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsMust;

	/**
	 *  是否关键属性，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsSpuKey;

	/**
	 *  是否SPU一般属性，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsSpuComm;

	/**
	 *  是否销售属性，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsSkuSale;

	/**
	 *  是否一般属性，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsSkuComm;

	/**
	 *  是否搜索聚合属性，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsSearchJoint;

	/**
	 *  是否商详隐藏属性，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsHideSX;

	/**
	 *  是否支持卖家对属性项设置别名，0为否，其余为是 
	 *
	 * 版本 >= 141
	 */
	 private long IsSellerAttrAlias;

	/**
	 *  是否支持卖家对属性值设置别名，0为否，其余为是 
	 *
	 * 版本 >= 141
	 */
	 private long IsSellerOptAlias;

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
	 * 对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
	 *
	 * 版本 >= 143
	 */
	 private long ShowType;

	/**
	 * 对品类有用，属性项分组id
	 *
	 * 版本 >= 144
	 */
	 private long GroupId;

	/**
	 * 对品类有用，属性项分组名
	 *
	 * 版本 >= 144
	 */
	 private String GroupName = new String();

	/**
	 * 对品类有用，属性项分组排序
	 *
	 * 版本 >= 144
	 */
	 private long GroupOrder;

	/**
	 * 额外数据，key是业务id，value是业务数据
	 *
	 * 版本 >= 145
	 */
	 private Map<uint32_t,String> ExtraData = new HashMap<uint32_t,String>();

	/**
	 * 标记位，具体定义参见ATTR_PROPERTY
	 *
	 * 版本 >= 146
	 */
	 private BitSet PropertyMask = new BitSet();

	/**
	 * 标记位，增大到64位，用于取代Property
	 *
	 * 版本 >= 147
	 */
	 private long Property64;

	/**
	 * 属性值单位，针对可数值化的属性值有用
	 *
	 * 版本 >= 147
	 */
	 private String Unit = new String();



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUByte(version);
		bs.pushUInt(AttrId);
		bs.pushUInt(NavId);
		bs.pushString(Name);
		bs.pushUInt(Property);
		bs.pushUInt(Type);
		bs.pushUInt(PAttrId);
		bs.pushUInt(POptionId);
		bs.pushString(Desc);
		bs.pushUInt(Order);
		bs.pushObject(Options);
		if(  this.version >= 140 ){
				bs.pushUInt(IsOptional);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsText);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsSingle);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsMulti);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsMust);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsSpuKey);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsSpuComm);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsSkuSale);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsSkuComm);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsSearchJoint);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsHideSX);
		}
		if(  this.version >= 141 ){
				bs.pushUInt(IsSellerAttrAlias);
		}
		if(  this.version >= 141 ){
				bs.pushUInt(IsSellerOptAlias);
		}
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
				bs.pushUInt(ShowType);
		}
		if(  this.version >= 144 ){
				bs.pushUInt(GroupId);
		}
		if(  this.version >= 144 ){
				bs.pushString(GroupName);
		}
		if(  this.version >= 144 ){
				bs.pushUInt(GroupOrder);
		}
		if(  this.version >= 145 ){
				bs.pushObject(ExtraData);
		}
		if(  this.version >= 146 ){
				bs.pushBitSet(PropertyMask);
		}
		if(  this.version >= 147 ){
				bs.pushLong(Property64);
		}
		if(  this.version >= 147 ){
				bs.pushString(Unit);
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
		NavId = bs.popUInt();
		Name = bs.popString();
		Property = bs.popUInt();
		Type = bs.popUInt();
		PAttrId = bs.popUInt();
		POptionId = bs.popUInt();
		Desc = bs.popString();
		Order = bs.popUInt();
		Options = (Vector<OptionDdo>)bs.popVector(OptionDdo.class);
		if(  version >= 140 ){
				IsOptional = bs.popUInt();
		}
		if(  version >= 140 ){
				IsText = bs.popUInt();
		}
		if(  version >= 140 ){
				IsSingle = bs.popUInt();
		}
		if(  version >= 140 ){
				IsMulti = bs.popUInt();
		}
		if(  version >= 140 ){
				IsMust = bs.popUInt();
		}
		if(  version >= 140 ){
				IsSpuKey = bs.popUInt();
		}
		if(  version >= 140 ){
				IsSpuComm = bs.popUInt();
		}
		if(  version >= 140 ){
				IsSkuSale = bs.popUInt();
		}
		if(  version >= 140 ){
				IsSkuComm = bs.popUInt();
		}
		if(  version >= 140 ){
				IsSearchJoint = bs.popUInt();
		}
		if(  version >= 140 ){
				IsHideSX = bs.popUInt();
		}
		if(  version >= 141 ){
				IsSellerAttrAlias = bs.popUInt();
		}
		if(  version >= 141 ){
				IsSellerOptAlias = bs.popUInt();
		}
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
				ShowType = bs.popUInt();
		}
		if(  version >= 144 ){
				GroupId = bs.popUInt();
		}
		if(  version >= 144 ){
				GroupName = bs.popString();
		}
		if(  version >= 144 ){
				GroupOrder = bs.popUInt();
		}
		if(  version >= 145 ){
				ExtraData = (Map<uint32_t,String>)bs.popMap(uint32_t.class,String.class);
		}
		if(  version >= 146 ){
				PropertyMask = bs.popBitSet();
		}
		if(  version >= 147 ){
				Property64 = bs.popLong();
		}
		if(  version >= 147 ){
				Unit = bs.popString();
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
	 * 获取导航id
	 * 
	 * 此字段的版本 >= 0
	 * @return NavId value 类型为:long
	 * 
	 */
	public long getNavId()
	{
		return NavId;
	}


	/**
	 * 设置导航id
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setNavId(long value)
	{
		this.NavId = value;
	}


	/**
	 * 获取属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
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
	 * 设置属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
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
	 * 获取父属性项id
	 * 
	 * 此字段的版本 >= 0
	 * @return PAttrId value 类型为:long
	 * 
	 */
	public long getPAttrId()
	{
		return PAttrId;
	}


	/**
	 * 设置父属性项id
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setPAttrId(long value)
	{
		this.PAttrId = value;
	}


	/**
	 * 获取父属性值id
	 * 
	 * 此字段的版本 >= 0
	 * @return POptionId value 类型为:long
	 * 
	 */
	public long getPOptionId()
	{
		return POptionId;
	}


	/**
	 * 设置父属性值id
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setPOptionId(long value)
	{
		this.POptionId = value;
	}


	/**
	 * 获取 属性项描述 
	 * 
	 * 此字段的版本 >= 0
	 * @return Desc value 类型为:String
	 * 
	 */
	public String getDesc()
	{
		return Desc;
	}


	/**
	 * 设置 属性项描述 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setDesc(String value)
	{
		this.Desc = value;
	}


	/**
	 * 获取 属性项排序 
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
	 * 设置 属性项排序 
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
	 * 获取 属性值集合 
	 * 
	 * 此字段的版本 >= 0
	 * @return Options value 类型为:Vector<OptionDdo>
	 * 
	 */
	public Vector<OptionDdo> getOptions()
	{
		return Options;
	}


	/**
	 * 设置 属性值集合 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<OptionDdo>
	 * 
	 */
	public void setOptions(Vector<OptionDdo> value)
	{
		if (value != null) {
				this.Options = value;
		}else{
				this.Options = new Vector<OptionDdo>();
		}
	}


	/**
	 * 获取 是否选项，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsOptional value 类型为:long
	 * 
	 */
	public long getIsOptional()
	{
		return IsOptional;
	}


	/**
	 * 设置 是否选项，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsOptional(long value)
	{
		this.IsOptional = value;
	}


	/**
	 * 获取 是否文本，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsText value 类型为:long
	 * 
	 */
	public long getIsText()
	{
		return IsText;
	}


	/**
	 * 设置 是否文本，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsText(long value)
	{
		this.IsText = value;
	}


	/**
	 * 获取 是否单选，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsSingle value 类型为:long
	 * 
	 */
	public long getIsSingle()
	{
		return IsSingle;
	}


	/**
	 * 设置 是否单选，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSingle(long value)
	{
		this.IsSingle = value;
	}


	/**
	 * 获取 是否多选，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsMulti value 类型为:long
	 * 
	 */
	public long getIsMulti()
	{
		return IsMulti;
	}


	/**
	 * 设置 是否多选，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsMulti(long value)
	{
		this.IsMulti = value;
	}


	/**
	 * 获取 是否可选，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsMust value 类型为:long
	 * 
	 */
	public long getIsMust()
	{
		return IsMust;
	}


	/**
	 * 设置 是否可选，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsMust(long value)
	{
		this.IsMust = value;
	}


	/**
	 * 获取 是否关键属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsSpuKey value 类型为:long
	 * 
	 */
	public long getIsSpuKey()
	{
		return IsSpuKey;
	}


	/**
	 * 设置 是否关键属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSpuKey(long value)
	{
		this.IsSpuKey = value;
	}


	/**
	 * 获取 是否SPU一般属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsSpuComm value 类型为:long
	 * 
	 */
	public long getIsSpuComm()
	{
		return IsSpuComm;
	}


	/**
	 * 设置 是否SPU一般属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSpuComm(long value)
	{
		this.IsSpuComm = value;
	}


	/**
	 * 获取 是否销售属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsSkuSale value 类型为:long
	 * 
	 */
	public long getIsSkuSale()
	{
		return IsSkuSale;
	}


	/**
	 * 设置 是否销售属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSkuSale(long value)
	{
		this.IsSkuSale = value;
	}


	/**
	 * 获取 是否一般属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsSkuComm value 类型为:long
	 * 
	 */
	public long getIsSkuComm()
	{
		return IsSkuComm;
	}


	/**
	 * 设置 是否一般属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSkuComm(long value)
	{
		this.IsSkuComm = value;
	}


	/**
	 * 获取 是否搜索聚合属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsSearchJoint value 类型为:long
	 * 
	 */
	public long getIsSearchJoint()
	{
		return IsSearchJoint;
	}


	/**
	 * 设置 是否搜索聚合属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSearchJoint(long value)
	{
		this.IsSearchJoint = value;
	}


	/**
	 * 获取 是否商详隐藏属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsHideSX value 类型为:long
	 * 
	 */
	public long getIsHideSX()
	{
		return IsHideSX;
	}


	/**
	 * 设置 是否商详隐藏属性，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsHideSX(long value)
	{
		this.IsHideSX = value;
	}


	/**
	 * 获取 是否支持卖家对属性项设置别名，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 141
	 * @return IsSellerAttrAlias value 类型为:long
	 * 
	 */
	public long getIsSellerAttrAlias()
	{
		return IsSellerAttrAlias;
	}


	/**
	 * 设置 是否支持卖家对属性项设置别名，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 141
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSellerAttrAlias(long value)
	{
		this.IsSellerAttrAlias = value;
	}


	/**
	 * 获取 是否支持卖家对属性值设置别名，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 141
	 * @return IsSellerOptAlias value 类型为:long
	 * 
	 */
	public long getIsSellerOptAlias()
	{
		return IsSellerOptAlias;
	}


	/**
	 * 设置 是否支持卖家对属性值设置别名，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 141
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsSellerOptAlias(long value)
	{
		this.IsSellerOptAlias = value;
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
	 * 获取对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
	 * 
	 * 此字段的版本 >= 143
	 * @return ShowType value 类型为:long
	 * 
	 */
	public long getShowType()
	{
		return ShowType;
	}


	/**
	 * 设置对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
	 * 
	 * 此字段的版本 >= 143
	 * @param  value 类型为:long
	 * 
	 */
	public void setShowType(long value)
	{
		this.ShowType = value;
	}


	/**
	 * 获取对品类有用，属性项分组id
	 * 
	 * 此字段的版本 >= 144
	 * @return GroupId value 类型为:long
	 * 
	 */
	public long getGroupId()
	{
		return GroupId;
	}


	/**
	 * 设置对品类有用，属性项分组id
	 * 
	 * 此字段的版本 >= 144
	 * @param  value 类型为:long
	 * 
	 */
	public void setGroupId(long value)
	{
		this.GroupId = value;
	}


	/**
	 * 获取对品类有用，属性项分组名
	 * 
	 * 此字段的版本 >= 144
	 * @return GroupName value 类型为:String
	 * 
	 */
	public String getGroupName()
	{
		return GroupName;
	}


	/**
	 * 设置对品类有用，属性项分组名
	 * 
	 * 此字段的版本 >= 144
	 * @param  value 类型为:String
	 * 
	 */
	public void setGroupName(String value)
	{
		this.GroupName = value;
	}


	/**
	 * 获取对品类有用，属性项分组排序
	 * 
	 * 此字段的版本 >= 144
	 * @return GroupOrder value 类型为:long
	 * 
	 */
	public long getGroupOrder()
	{
		return GroupOrder;
	}


	/**
	 * 设置对品类有用，属性项分组排序
	 * 
	 * 此字段的版本 >= 144
	 * @param  value 类型为:long
	 * 
	 */
	public void setGroupOrder(long value)
	{
		this.GroupOrder = value;
	}


	/**
	 * 获取额外数据，key是业务id，value是业务数据
	 * 
	 * 此字段的版本 >= 145
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
	 * 此字段的版本 >= 145
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
	 * 获取标记位，具体定义参见ATTR_PROPERTY
	 * 
	 * 此字段的版本 >= 146
	 * @return PropertyMask value 类型为:BitSet
	 * 
	 */
	public BitSet getPropertyMask()
	{
		return PropertyMask;
	}


	/**
	 * 设置标记位，具体定义参见ATTR_PROPERTY
	 * 
	 * 此字段的版本 >= 146
	 * @param  value 类型为:BitSet
	 * 
	 */
	public void setPropertyMask(BitSet value)
	{
		if (value != null) {
				this.PropertyMask = value;
		}else{
				this.PropertyMask = new BitSet();
		}
	}


	/**
	 * 获取标记位，增大到64位，用于取代Property
	 * 
	 * 此字段的版本 >= 147
	 * @return Property64 value 类型为:long
	 * 
	 */
	public long getProperty64()
	{
		return Property64;
	}


	/**
	 * 设置标记位，增大到64位，用于取代Property
	 * 
	 * 此字段的版本 >= 147
	 * @param  value 类型为:long
	 * 
	 */
	public void setProperty64(long value)
	{
		this.Property64 = value;
	}


	/**
	 * 获取属性值单位，针对可数值化的属性值有用
	 * 
	 * 此字段的版本 >= 147
	 * @return Unit value 类型为:String
	 * 
	 */
	public String getUnit()
	{
		return Unit;
	}


	/**
	 * 设置属性值单位，针对可数值化的属性值有用
	 * 
	 * 此字段的版本 >= 147
	 * @param  value 类型为:String
	 * 
	 */
	public void setUnit(String value)
	{
		this.Unit = value;
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
				length = 4;  //size_of(AttrDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段AttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段NavId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Name, null);  //计算字段Name的长度 size_of(String)
				length += 4;  //计算字段Property的长度 size_of(uint32_t)
				length += 4;  //计算字段Type的长度 size_of(uint32_t)
				length += 4;  //计算字段PAttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段POptionId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Desc, null);  //计算字段Desc的长度 size_of(String)
				length += 4;  //计算字段Order的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Options, null);  //计算字段Options的长度 size_of(Vector)
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsOptional的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsText的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSingle的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsMulti的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsMust的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSpuKey的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSpuComm的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSkuSale的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSkuComm的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSearchJoint的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsHideSX的长度 size_of(uint32_t)
				}
				if(  this.version >= 141 ){
						length += 4;  //计算字段IsSellerAttrAlias的长度 size_of(uint32_t)
				}
				if(  this.version >= 141 ){
						length += 4;  //计算字段IsSellerOptAlias的长度 size_of(uint32_t)
				}
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
						length += 4;  //计算字段ShowType的长度 size_of(uint32_t)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段GroupId的长度 size_of(uint32_t)
				}
				if(  this.version >= 144 ){
						length += ByteStream.getObjectSize(GroupName, null);  //计算字段GroupName的长度 size_of(String)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段GroupOrder的长度 size_of(uint32_t)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(ExtraData, null);  //计算字段ExtraData的长度 size_of(Map)
				}
				if(  this.version >= 146 ){
						length += ByteStream.getObjectSize(PropertyMask, null);  //计算字段PropertyMask的长度 size_of(BitSet)
				}
				if(  this.version >= 147 ){
						length += 17;  //计算字段Property64的长度 size_of(uint64_t)
				}
				if(  this.version >= 147 ){
						length += ByteStream.getObjectSize(Unit, null);  //计算字段Unit的长度 size_of(String)
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
				length = 4;  //size_of(AttrDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段AttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段NavId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Name, encoding);  //计算字段Name的长度 size_of(String)
				length += 4;  //计算字段Property的长度 size_of(uint32_t)
				length += 4;  //计算字段Type的长度 size_of(uint32_t)
				length += 4;  //计算字段PAttrId的长度 size_of(uint32_t)
				length += 4;  //计算字段POptionId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Desc, encoding);  //计算字段Desc的长度 size_of(String)
				length += 4;  //计算字段Order的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Options, encoding);  //计算字段Options的长度 size_of(Vector)
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsOptional的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsText的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSingle的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsMulti的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsMust的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSpuKey的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSpuComm的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSkuSale的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSkuComm的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsSearchJoint的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsHideSX的长度 size_of(uint32_t)
				}
				if(  this.version >= 141 ){
						length += 4;  //计算字段IsSellerAttrAlias的长度 size_of(uint32_t)
				}
				if(  this.version >= 141 ){
						length += 4;  //计算字段IsSellerOptAlias的长度 size_of(uint32_t)
				}
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
						length += 4;  //计算字段ShowType的长度 size_of(uint32_t)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段GroupId的长度 size_of(uint32_t)
				}
				if(  this.version >= 144 ){
						length += ByteStream.getObjectSize(GroupName, encoding);  //计算字段GroupName的长度 size_of(String)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段GroupOrder的长度 size_of(uint32_t)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(ExtraData, encoding);  //计算字段ExtraData的长度 size_of(Map)
				}
				if(  this.version >= 146 ){
						length += ByteStream.getObjectSize(PropertyMask, encoding);  //计算字段PropertyMask的长度 size_of(BitSet)
				}
				if(  this.version >= 147 ){
						length += 17;  //计算字段Property64的长度 size_of(uint64_t)
				}
				if(  this.version >= 147 ){
						length += ByteStream.getObjectSize(Unit, encoding);  //计算字段Unit的长度 size_of(String)
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
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	long ShowType;///<对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
 *	long GroupId;///<对品类有用，属性项分组id
 *	String GroupName;///<对品类有用，属性项分组名
 *	long GroupOrder;///<对品类有用，属性项分组排序
 *****以上是版本144所包含的字段*******
 *
 *****以下是版本145所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	long ShowType;///<对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
 *	long GroupId;///<对品类有用，属性项分组id
 *	String GroupName;///<对品类有用，属性项分组名
 *	long GroupOrder;///<对品类有用，属性项分组排序
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *****以上是版本145所包含的字段*******
 *
 *****以下是版本146所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	long ShowType;///<对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
 *	long GroupId;///<对品类有用，属性项分组id
 *	String GroupName;///<对品类有用，属性项分组名
 *	long GroupOrder;///<对品类有用，属性项分组排序
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	BitSet PropertyMask;///<标记位，具体定义参见ATTR_PROPERTY
 *****以上是版本146所包含的字段*******
 *
 *****以下是版本147所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	long ShowType;///<对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
 *	long GroupId;///<对品类有用，属性项分组id
 *	String GroupName;///<对品类有用，属性项分组名
 *	long GroupOrder;///<对品类有用，属性项分组排序
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	BitSet PropertyMask;///<标记位，具体定义参见ATTR_PROPERTY
 *	long Property64;///<标记位，增大到64位，用于取代Property
 *	String Unit;///<属性值单位，针对可数值化的属性值有用
 *****以上是版本147所包含的字段*******
 *
 *****以下是版本140所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *****以上是版本140所包含的字段*******
 *
 *****以下是版本141所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *****以上是版本141所包含的字段*******
 *
 *****以下是版本142所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *****以上是版本142所包含的字段*******
 *
 *****以下是版本143所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long AttrId;///< 属性项id 
 *	long NavId;///<导航id
 *	String Name;///<属性项名称，根据NameSeller、NameOperator、NameOriginal得出的综合结果
 *	long Property;///< property 
 *	long Type;///< 类型 
 *	long PAttrId;///<父属性项id
 *	long POptionId;///<父属性值id
 *	String Desc;///< 属性项描述 
 *	long Order;///< 属性项排序 
 *	Vector<OptionDdo> Options;///< 属性值集合 
 *	long IsOptional;///< 是否选项，0为否，其余为是 
 *	long IsText;///< 是否文本，0为否，其余为是 
 *	long IsSingle;///< 是否单选，0为否，其余为是 
 *	long IsMulti;///< 是否多选，0为否，其余为是 
 *	long IsMust;///< 是否可选，0为否，其余为是 
 *	long IsSpuKey;///< 是否关键属性，0为否，其余为是 
 *	long IsSpuComm;///< 是否SPU一般属性，0为否，其余为是 
 *	long IsSkuSale;///< 是否销售属性，0为否，其余为是 
 *	long IsSkuComm;///< 是否一般属性，0为否，其余为是 
 *	long IsSearchJoint;///< 是否搜索聚合属性，0为否，其余为是 
 *	long IsHideSX;///< 是否商详隐藏属性，0为否，其余为是 
 *	long IsSellerAttrAlias;///< 是否支持卖家对属性项设置别名，0为否，其余为是 
 *	long IsSellerOptAlias;///< 是否支持卖家对属性值设置别名，0为否，其余为是 
 *	String NameOriginal;///<原始名
 *	String NameOperator;///<运营加挂时定义的别名
 *	String NameSeller;///<卖家自定义名
 *	long ShowType;///<对搜索导航有用，属性值展现方式，0:不展示，1:显示图片，2:显示文字，3：显示图片和文字
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
