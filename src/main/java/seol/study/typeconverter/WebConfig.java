package seol.study.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import seol.study.typeconverter.converter.IntegerToStringConverter;
import seol.study.typeconverter.converter.IpPortToStringConverter;
import seol.study.typeconverter.converter.StringToIntegerConverter;
import seol.study.typeconverter.converter.StringToIpPortConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 추가하고 싶은 Converter를 Spring에 등록.
	 * @param registry
	 */
	@Override public void addFormatters(final FormatterRegistry registry) {
		registry.addConverter(new StringToIntegerConverter());
		registry.addConverter(new IntegerToStringConverter());
		registry.addConverter(new StringToIpPortConverter());
		registry.addConverter(new IpPortToStringConverter());
	}

}
