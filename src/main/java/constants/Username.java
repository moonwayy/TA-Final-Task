package constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Username {
    USERNAME("standard_user");

    private final String value;
}
