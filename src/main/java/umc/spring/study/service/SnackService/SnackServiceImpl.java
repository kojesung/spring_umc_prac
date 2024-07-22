package umc.spring.study.service.SnackService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.converter.SnackConverter;
import umc.spring.study.repository.SnackRepository;
import umc.spring.study.web.dto.SnackResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SnackServiceImpl implements SnackService{
    private final SnackRepository snackRepository;

    @Override
    public List<SnackResponseDTO.SnackDTO> getAllSnacks() {
        List<SnackResponseDTO.SnackDTO> snacks = snackRepository.findAll().stream()
                .map(snack -> {
                    return SnackConverter.toSnackDTO(snack);
                })
                .collect(Collectors.toList());
        return snacks;
    }
}
