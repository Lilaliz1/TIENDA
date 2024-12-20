@Controller
@Slf4j
@RequestMapping("/reportes") // Ruta del controlador
public class ReporteController {
 
    @Autowired
    private ReporteService reporteService;
 
    @GetMapping("/principal")
    public String principal(Model model) {
        return "/reportes/principal";
    }
    @GetMapping("/usuarios")
    public ResponseEntity<Resource> usuarios(@RequestParam String tipo) throws IOException {
 
        return reporteService.generaReporte("usuarios", null, tipo);
    }
 
    @GetMapping("/ventas")
    public ResponseEntity<Resource> ventas(@RequestParam String tipo) throws IOException {
 
        return reporteService.generaReporte("ventas", null, tipo);
    }