package cn.dev33.satoken.listener;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpLogic;

/**
 * Sa-Token 侦听器
 * <p> 你可以通过实现此接口在用户登陆、退出等关键性操作时进行一些AOP操作 
 * @author kong
 *
 */
public interface SaTokenListener {

	/**
	 * 每次登录时触发 
	 * @param loginType 账号类别
	 * @param loginId 账号id
	 * @param tokenValue 本次登录产生的 token 值 
	 * @param loginModel 登录参数
	 */
	public void doLogin(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel);
			
	/**
	 * 每次注销时触发 
	 * @param loginType 账号类别
	 * @param loginId 账号id
	 * @param tokenValue token值
	 */
	public void doLogout(String loginType, Object loginId, String tokenValue);
	
	/**
	 * 每次被踢下线时触发 
	 * @param loginType 账号类别 
	 * @param loginId 账号id 
	 * @param tokenValue token值 
	 */
	public void doKickout(String loginType, Object loginId, String tokenValue);

	/**
	 * 每次被顶下线时触发
	 * @param loginType 账号类别
	 * @param loginId 账号id
	 * @param tokenValue token值
	 */
	public void doReplaced(String loginType, Object loginId, String tokenValue);

	/**
	 * 每次被封禁时触发
	 * @param loginType 账号类别
	 * @param loginId 账号id
	 * @param service 指定服务 
	 * @param level 封禁等级 
	 * @param disableTime 封禁时长，单位: 秒
	 */
	public void doDisable(String loginType, Object loginId, String service, int level, long disableTime);
	
	/**
	 * 每次被解封时触发
	 * @param loginType 账号类别
	 * @param loginId 账号id
	 * @param service 指定服务 
	 */
	public void doUntieDisable(String loginType, Object loginId, String service);

	/**
	 * 每次打开二级认证时触发
	 * @param loginType 账号类别
	 * @param tokenValue token值
	 * @param service 指定服务 
	 * @param safeTime 认证时间，单位：秒 
	 */
	public void doOpenSafe(String loginType, String tokenValue, String service, long safeTime);

	/**
	 * 每次关闭二级认证时触发
	 * @param loginType 账号类别
	 * @param tokenValue token值
	 * @param service 指定服务 
	 */
	public void doCloseSafe(String loginType, String tokenValue, String service);

	/**
	 * 每次创建Session时触发
	 * @param id SessionId
	 */
	public void doCreateSession(String id);
	
	/**
	 * 每次注销Session时触发
	 * @param id SessionId
	 */
	public void doLogoutSession(String id);

	/**
	 * 每次Token续期时触发 
	 * 
	 * @param tokenValue token 值 
	 * @param loginId 账号id 
	 * @param timeout 续期时间 
	 */
	public void doRenewTimeout(String tokenValue,  Object loginId, long timeout);

	/**
	 * 全局组件载入 
	 * @param comtName 组件名称 
	 * @param comtObj 组件对象 
	 */
	public default void doRegisterComponent(String comtName, Object comtObj) {}

	/**
	 * StpLogic 对象替换 
	 * @param stpLogic / 
	 */
	public default void doSetStpLogic(StpLogic stpLogic) {}

	/**
	 * 载入全局配置 
	 * @param stpLogic / 
	 */
	public default void doSetConfig(SaTokenConfig config) {}

}
