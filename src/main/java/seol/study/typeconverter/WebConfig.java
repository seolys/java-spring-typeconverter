package seol.study.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import seol.study.typeconverter.converter.IpPortToStringConverter;
import seol.study.typeconverter.converter.StringToIpPortConverter;
import seol.study.typeconverter.formatter.MyNumberFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 추가하고 싶은 Converter를 Spring에 등록.
	 * @param registry
	 */
	@Override
	public void addFormatters(final FormatterRegistry registry) {
		// Formatter테스트를 위해 주석처리.(Converter가 Formatter보다 우선순위를 가짐)
//		registry.addConverter(new StringToIntegerConverter());
//		registry.addConverter(new IntegerToStringConverter());
		registry.addConverter(new StringToIpPortConverter());
		registry.addConverter(new IpPortToStringConverter());

		registry.addFormatter(new MyNumberFormatter());
	}

}
