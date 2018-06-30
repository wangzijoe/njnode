package cn.njnode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SpaceName {

	public enum space{
		item,
		system,
		subscriber,
		store
	}
	space value() default space.system;
}
