//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.GetMetaClassEx_WGResp.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.lang.GenericWrapper;
import com.paipai.lang.uint32_t;
import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 导航结构体 
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:0
*/
public class NavExDdo  implements ICanSerializeObjectExt4Encoding
{
	/**
	 *  版本号, version需要小写 
	 *
	 * 版本 >= 0
	 */
	 private short version = 140;

	/**
	 *  导航信息 
	 *
	 * 版本 >= 0
	 */
	 private NavEntryDdo NavNode = new NavEntryDdo();

	/**
	 *  导航路径 
	 *
	 * 版本 >= 0
	 */
	 private Vector<NavEntryDdo> FullPath = new Vector<NavEntryDdo>();

	/**
	 *  搜索导航路径 
	 *
	 * 版本 >= 0
	 */
	 private Vector<NavEntryDdo> MetaSearchPath = new Vector<NavEntryDdo>();

	/**
	 *  儿子导航 
	 *
	 * 版本 >= 0
	 */
	 private Vector<NavEntryDdo> ChildNode = new Vector<NavEntryDdo>();

	/**
	 *  直接儿子属性 
	 *
	 * 版本 >= 0
	 */
	 private Map<uint32_t,Vector<SubAttrOptionDdo>> ChildAttrId = new HashMap<uint32_t,Vector<SubAttrOptionDdo>>();

	/**
	 *  属性字典 
	 *
	 * 版本 >= 0
	 */
	 private Map<uint32_t,AttrDdo> AttrDic = new HashMap<uint32_t,AttrDdo>();

	/**
	 * 额外数据，key是业务id，value是业务数据
	 *
	 * 版本 >= 140
	 */
	 private Map<uint32_t,String> ExtraData = new HashMap<uint32_t,String>();



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUByte(version);
		bs.pushObject(NavNode);
		bs.pushObject(FullPath);
		bs.pushObject(MetaSearchPath);
		bs.pushObject(ChildNode);
		bs.pushObject(ChildAttrId);
		bs.pushObject(AttrDic);
		if(  this.version >= 140 ){
				bs.pushObject(ExtraData);
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
		NavNode = (NavEntryDdo) bs.popObject(NavEntryDdo.class);
		FullPath = (Vector<NavEntryDdo>)bs.popVector(NavEntryDdo.class);
		MetaSearchPath = (Vector<NavEntryDdo>)bs.popVector(NavEntryDdo.class);
		ChildNode = (Vector<NavEntryDdo>)bs.popVector(NavEntryDdo.class);

		// 生成反序列化属性ChildAttrId相应的范型参数包裹对象(包裹了该属性中范型的类型)。 
		GenericWrapper ChildAttrIdPaiPai00 = new GenericWrapper();
		ChildAttrIdPaiPai00.setType(HashMap.class);
		GenericWrapper[] ChildAttrIdPaiPaiArray00= new GenericWrapper[2];
		ChildAttrIdPaiPaiArray00[0] = new GenericWrapper(uint32_t.class);
		ChildAttrIdPaiPaiArray00[1] = new GenericWrapper();
		GenericWrapper ChildAttrIdPaiPai11 = new GenericWrapper();
		ChildAttrIdPaiPai11.setType(Vector.class);
		GenericWrapper[] ChildAttrIdPaiPaiArray11= new GenericWrapper[2];
		ChildAttrIdPaiPaiArray11[0] = new GenericWrapper(SubAttrOptionDdo.class);
		ChildAttrIdPaiPai11.setGenericParameters(ChildAttrIdPaiPaiArray11);


		ChildAttrIdPaiPaiArray00[1] = ChildAttrIdPaiPai11;
		ChildAttrIdPaiPai00.setGenericParameters(ChildAttrIdPaiPaiArray00);



		ChildAttrId = (Map<uint32_t,Vector<SubAttrOptionDdo>>)bs.popObject(ChildAttrIdPaiPai00);
		AttrDic = (Map<uint32_t,AttrDdo>)bs.popMap(uint32_t.class,AttrDdo.class);
		if(  version >= 140 ){
				ExtraData = (Map<uint32_t,String>)bs.popMap(uint32_t.class,String.class);
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
	 * 获取 导航信息 
	 * 
	 * 此字段的版本 >= 0
	 * @return NavNode value 类型为:NavEntryDdo
	 * 
	 */
	public NavEntryDdo getNavNode()
	{
		return NavNode;
	}


	/**
	 * 设置 导航信息 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:NavEntryDdo
	 * 
	 */
	public void setNavNode(NavEntryDdo value)
	{
		if (value != null) {
				this.NavNode = value;
		}else{
				this.NavNode = new NavEntryDdo();
		}
	}


	/**
	 * 获取 导航路径 
	 * 
	 * 此字段的版本 >= 0
	 * @return FullPath value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public Vector<NavEntryDdo> getFullPath()
	{
		return FullPath;
	}


	/**
	 * 设置 导航路径 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public void setFullPath(Vector<NavEntryDdo> value)
	{
		if (value != null) {
				this.FullPath = value;
		}else{
				this.FullPath = new Vector<NavEntryDdo>();
		}
	}


	/**
	 * 获取 搜索导航路径 
	 * 
	 * 此字段的版本 >= 0
	 * @return MetaSearchPath value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public Vector<NavEntryDdo> getMetaSearchPath()
	{
		return MetaSearchPath;
	}


	/**
	 * 设置 搜索导航路径 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public void setMetaSearchPath(Vector<NavEntryDdo> value)
	{
		if (value != null) {
				this.MetaSearchPath = value;
		}else{
				this.MetaSearchPath = new Vector<NavEntryDdo>();
		}
	}


	/**
	 * 获取 儿子导航 
	 * 
	 * 此字段的版本 >= 0
	 * @return ChildNode value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public Vector<NavEntryDdo> getChildNode()
	{
		return ChildNode;
	}


	/**
	 * 设置 儿子导航 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<NavEntryDdo>
	 * 
	 */
	public void setChildNode(Vector<NavEntryDdo> value)
	{
		if (value != null) {
				this.ChildNode = value;
		}else{
				this.ChildNode = new Vector<NavEntryDdo>();
		}
	}


	/**
	 * 获取 直接儿子属性 
	 * 
	 * 此字段的版本 >= 0
	 * @return ChildAttrId value 类型为:Map<uint32_t,Vector<SubAttrOptionDdo>>
	 * 
	 */
	public Map<uint32_t,Vector<SubAttrOptionDdo>> getChildAttrId()
	{
		return ChildAttrId;
	}


	/**
	 * 设置 直接儿子属性 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Map<uint32_t,Vector<SubAttrOptionDdo>>
	 * 
	 */
	public void setChildAttrId(Map<uint32_t,Vector<SubAttrOptionDdo>> value)
	{
		if (value != null) {
				this.ChildAttrId = value;
		}else{
				this.ChildAttrId = new HashMap<uint32_t,Vector<SubAttrOptionDdo>>();
		}
	}


	/**
	 * 获取 属性字典 
	 * 
	 * 此字段的版本 >= 0
	 * @return AttrDic value 类型为:Map<uint32_t,AttrDdo>
	 * 
	 */
	public Map<uint32_t,AttrDdo> getAttrDic()
	{
		return AttrDic;
	}


	/**
	 * 设置 属性字典 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Map<uint32_t,AttrDdo>
	 * 
	 */
	public void setAttrDic(Map<uint32_t,AttrDdo> value)
	{
		if (value != null) {
				this.AttrDic = value;
		}else{
				this.AttrDic = new HashMap<uint32_t,AttrDdo>();
		}
	}


	/**
	 * 获取额外数据，key是业务id，value是业务数据
	 * 
	 * 此字段的版本 >= 140
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
	 * 此字段的版本 >= 140
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
				length = 4;  //size_of(NavExDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(NavNode, null);  //计算字段NavNode的长度 size_of(NavEntryDdo)
				length += ByteStream.getObjectSize(FullPath, null);  //计算字段FullPath的长度 size_of(Vector)
				length += ByteStream.getObjectSize(MetaSearchPath, null);  //计算字段MetaSearchPath的长度 size_of(Vector)
				length += ByteStream.getObjectSize(ChildNode, null);  //计算字段ChildNode的长度 size_of(Vector)
				length += ByteStream.getObjectSize(ChildAttrId, null);  //计算字段ChildAttrId的长度 size_of(Map)
				length += ByteStream.getObjectSize(AttrDic, null);  //计算字段AttrDic的长度 size_of(Map)
				if(  this.version >= 140 ){
						length += ByteStream.getObjectSize(ExtraData, null);  //计算字段ExtraData的长度 size_of(Map)
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
				length = 4;  //size_of(NavExDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(NavNode, encoding);  //计算字段NavNode的长度 size_of(NavEntryDdo)
				length += ByteStream.getObjectSize(FullPath, encoding);  //计算字段FullPath的长度 size_of(Vector)
				length += ByteStream.getObjectSize(MetaSearchPath, encoding);  //计算字段MetaSearchPath的长度 size_of(Vector)
				length += ByteStream.getObjectSize(ChildNode, encoding);  //计算字段ChildNode的长度 size_of(Vector)
				length += ByteStream.getObjectSize(ChildAttrId, encoding);  //计算字段ChildAttrId的长度 size_of(Map)
				length += ByteStream.getObjectSize(AttrDic, encoding);  //计算字段AttrDic的长度 size_of(Map)
				if(  this.version >= 140 ){
						length += ByteStream.getObjectSize(ExtraData, encoding);  //计算字段ExtraData的长度 size_of(Map)
				}
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


/**
 ********************以下信息是每个版本的字段********************
 *
 *****以下是版本140所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	NavEntryDdo NavNode;///< 导航信息 
 *	Vector<NavEntryDdo> FullPath;///< 导航路径 
 *	Vector<NavEntryDdo> MetaSearchPath;///< 搜索导航路径 
 *	Vector<NavEntryDdo> ChildNode;///< 儿子导航 
 *	Map<uint32_t,Vector<SubAttrOptionDdo>> ChildAttrId;///< 直接儿子属性 
 *	Map<uint32_t,AttrDdo> AttrDic;///< 属性字典 
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *****以上是版本140所包含的字段*******
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
