package web.service.face.adopt;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import web.dto.AdoptFile;
import web.dto.AdoptPro;
import web.dto.AdoptResrchFile;
import web.dto.AdoptWish;
import web.util.Paging;

public interface AdoptService {

	/**
	 * 입양프로필 목록을 위한 페이징 객체를 생성한다
	 * 
	 * 	파라미터 curPage(현재 페이지)
	 * 	DB에서 조회한 totalCount(총 게시글 수)
	 * 	두 가지 데이터를 활용하여 페이징객체를 생성하여 반환한다
	 * 
	 * @param curPage - 요청 페이지 번호
	 * @return 계산이 완료된 Paging객체
	 */
	public Paging getProPaging(int curPage);

	/**
	 * 페이징이 적용된 입양프로필 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 페이징이 적용된 입양프로필 목록
	 */
	public List<Map<String, Object>> proList(Paging paging);

	/**
	 * 객체 찜 확인 후 추가나 삭제
	 * 
	 * @param adoptWish 찜 정보 객체
	 * @return 1:찜추가 0:찜삭제
	 */
	public int proWish(AdoptWish adoptWish);

	/**
	 * 찜목록전체조회
	 * 과 입양프로필 같이 전체조회하는거 만ㄷㄹ기!!!!!!!!! list에서
	 * @param adoptWish 찜 정보 객체
	 * @return
	 */
	public List<AdoptWish> proWishList();

	/**
	 *로그인한 회원이 찜한 목록 조회
	 * 
	 * @param userno 회원 번호
	 * @return
	 */
	public List<AdoptWish> wishList(int userno);

	/**
	 * 회원이 찜한 입양프로필의 상세 정보 조회
	 * 
	 * @param aniNo - 찜한 입양프로필 번호
	 * @return
	 */
	public AdoptPro proWishDetail(int aniNo);

	/**
	 * 회원이 찜한 목록 개수
	 * 
	 * @param userno 회원 번호
	 * @return
	 */
	public int wishCount(int userno);

	/**
	 * 입양프로필내용 및 파일을 저장한다
	 * 
	 * @param adoptPro - 게시글 정보 객체
	 * @param fileList - 첨부파일 정보 객체
	 */
	public void writeProcess(AdoptPro adoptPro, List<MultipartFile> fileList);

	/**
	 * 파일 번호를 이용하여 업로드된 파일 정보를 조회한다
	 * 
	 * @param adoptFile - 조회할 파일 번호 객체
	 * @return 첨부 파일 정보
	 */
	public AdoptFile getAdoptFileDown(AdoptFile adoptFile);

	/**
	 * 입양프로필 상세보기
	 * 
	 * @param adoptPro - 상세 조회할 입양프로필 번호
	 * @return 상세 입양프로필
	 */
	public AdoptPro adoptView(AdoptPro adoptPro);

	/**
	 * 동물번호를 이용해 업로드된 이미지를 조회한다
	 * 
	 * @param adoptPro - 조회할 동물 번호
	 * @return 첨부이미지 정보
	 */
	public List<AdoptFile> getAdoptFile(AdoptPro adoptPro);
	
	/**
	 * 입양프로필 내용 및 파일을 수정한다
	 * 
	 * @param report - 게시글 정보 객체
	 * @param file - 첨부파일 정보 객체
	 */
	public void proUpdate(AdoptPro adoptPro, List<MultipartFile> fileList);

	/**
	 * 입양프로필 내용 및 첨부파일 삭제
	 * 
	 * @param adoptPro
	 */
	public void adoptDelete(AdoptPro adoptPro);

}
