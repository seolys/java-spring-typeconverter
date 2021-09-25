package seol.study.typeconverter.formatter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import seol.study.typeconverter.converter.IpPortToStringConverter;
import seol.study.typeconverter.converter.StringToIpPortConverter;
import seol.study.typeconverter.type.IpPort;

public class FormattingConversionServiceTest {

	@Test
	void formattingConversionServer() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		// 컨버터 등록
		conversionService.addConverter(new StringToIpPortConverter());
		conversionService.addConverter(new IpPortToStringConverter());

		// 포멧터 등록
		conversionService.addFormatter(new MyNumberFormatter());

		// 컨버터 사용
		IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
		assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

		// 포멧터 사용
		String convert = conversionService.convert(1000, String.class);
		assertThat(convert).isEqualTo("1,000");

		Long convertLong = conversionService.convert("1,000", Long.class);
		assertThat(convertLong).isEqualTo(1000L);
	}
}
