import java.util.Iterator;

/**
 * @author ZhangHao 
 * @date  2013-4-8
 */
public class RegEditTest {

	/*public static void main(String[] args) {
				//列出HKEY_CURRENT_USER的子键
				RegistryKey current_user = new RegistryKey(RootKey.HKEY_CURRENT_USER);
				if(current_user.hasSubkeys()){
					Iterator<RegistryKey> keys = current_user.subkeys();
					while(keys.hasNext()) {
						RegistryKey k = keys.next();
						System.out.println(k.getName());
					}
				}
				
				//列出 HKEY_CURRENT_USER/Environment 的所有键值的名称、类型和数据
				RegistryKey env = new RegistryKey(RootKey.HKEY_CURRENT_USER,"Environment");		
				if(env.hasValues()) {
					Iterator<RegistryValue> values = env.values();
					while(values.hasNext()) {
						RegistryValue v = values.next();
						System.out.println(v.getName()+"\t"+v.getType());
						System.out.println("\t"+v.getData());
					}
				}
				
				//写入注册表
				RegistryKey newKey = new RegistryKey(RootKey.HKEY_CURRENT_USER,"Environment\\NewKey");
				newKey.create();//创建新的键HKEY_CURRENT_USER/Environment/NewKey
				RegistryValue value = new RegistryValue("My Paht",ValueType.REG_SZ,"hahah\\lalal");
				newKey.setValue(value);//在新创建的键里写入键值,在注册表中按F5刷新一下能看到变化了吧
			}*/
	}
