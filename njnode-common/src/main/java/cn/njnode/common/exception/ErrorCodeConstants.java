package cn.njnode.common.exception;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ErrorCodeConstants {

	public static final String Unknown = init();

	/**
	 * 系统繁忙。
	 */
	public static final String SystemBusy = init();

	/**
	 * 系统错误。
	 */
	public static final String SystemError = init();

	public static interface GameErrorCode {

		public static final String GameNotFound = init();

		public static final String GameNameDuplicate = init();
	}

	public static interface ServerErrorCode {

		public static final String ServerNotFound = init();

		public static final String ServerPidMismatch = init();
	}

	public static interface FragmentErrorCode {

		public static final String FragmentNotFound = init();
	}

	public static interface TagErrorCode {

		public static final String TagNotFound = init();

		public static final String TagPidMismatch = init();
	}

	public static interface NewbieCardErrorCode {

		/**
		 * 未开始
		 */
		public static final String NewbieCardNotStart = init();

		/**
		 * 已结束
		 */
		public static final String NewbieCardEnded = init();

		/**
		 * 屏蔽
		 */
		public static final String NewbieCardShielded = init();

		/**
		 * 已领用过卡片
		 */
		public static final String NewbieCardCodeExist = init();

		/**
		 * 卡片不存在
		 */
		public static final String NewbieCardNotFound = init();

		/**
		 * 卡片已领完
		 */
		public static final String NewbieCardCodeNotFound = init();

		/**
		 * 获取卡密的应用名称有误
		 */
		public static final String NewbieCardIsNotPermitApp = init();
	}

	public static interface NewbieCardCodeErrorCode {

		public static final String NewbieCardCodeNOTFOUND = init();
	}

	public static interface CmsErrorCode {

		public static final String CmsError = init();
	}

	public static interface RetailItemsErrorCode {

		public static final String RetailItemsNotFound = init();

		/**
		 * 存在相同GameId的零售物品。
		 */
		public static final String ExistSameGameIdRetailItems = init();
	}

	public static interface GoldCoinStdUnitErrorCode {

		public static final String GoldCoinStdUnitNotFound = init();
	}

	static String init() {
		try {
			Class<?> cls = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
			for (Field f : cls.getFields())
				if ((f.getModifiers() & (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL)) != 0)
					if (f.get(null) == null)
						return f.getName();
			throw new UnsupportedOperationException();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
