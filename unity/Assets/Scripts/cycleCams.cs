using UnityEngine;
using System.Collections;

public class cycleCams : MonoBehaviour {

	public Camera[] cameras;
	public int cam;

	// Use this for initialization
	void Start () {
		Debug.Log("init");
		for (int i = 1; i<4; i++) {
			cameras[i].gameObject.SetActive(false);
		}
	}
	
	// Update is called once per frame
	void Update () {
		if(Input.GetKeyDown(KeyCode.F)){
			print("Switching camera");
			cameras[cam].gameObject.SetActive(false);
			cam++;
			if(cam == 4)
				cam = 0;
			cameras[cam].gameObject.SetActive(true);
		}
	}
}
